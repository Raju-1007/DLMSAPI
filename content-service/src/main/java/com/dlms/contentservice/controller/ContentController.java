package com.dlms.contentservice.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dlms.contentservice.model.LessonMaterial;
import com.dlms.contentservice.repo.LessonMaterialRepo;
import com.dlms.contentservice.service.StorageService;

@RestController
@RequestMapping
@CrossOrigin(origins = { "http://52.140.42.14:5173", "http://localhost:5173", "http://localhost:4173",
		"http://192.168.1.35:4173", "http://192.168.1.35:5173" })
public class ContentController {
	private final StorageService storage;

	@Autowired
	private String uploadRoot;

	@Autowired
	private LessonMaterialRepo repo;

	public ContentController(StorageService storage, LessonMaterialRepo repo) {
		this.storage = storage;
		this.repo = repo;

	}

//	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
//			@RequestParam("type") String type, @RequestParam("teacherid") String loginId) throws Exception {
//		System.out.println(file.getContentType() + "++++++++++++++++++++++++++++++++++");
//		String key = "uploads/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
//		storage.put(key, file.getInputStream(), file.getSize(), file.getContentType(), title, type, loginId);
//		return ResponseEntity.ok().body(java.util.Map.of("key", key));
//	}

//	@GetMapping("/download")
//	public ResponseEntity<byte[]> download(@RequestParam("key") String key) throws Exception {
//		System.out.println(key + ":::::::::::::::::::::::::::::kyr");
//		var res = storage.get(key);
//		byte[] bytes = res.readAllBytes();
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + key.replace("uploads/", ""))
//				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(bytes);
//	}

//	@GetMapping("/stream")
//	public ResponseEntity<Resource> stream(@RequestParam("key") String key) throws Exception {
//
//		InputStream stream = storage.get(key);
//		InputStreamResource resource = new InputStreamResource(stream);
//
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4")).body(resource);
//	}

	@GetMapping("/download")
public ResponseEntity<Resource> downloadFile(
        @RequestParam String filePath,
        @RequestParam String type) throws IOException {

    String folder;

    switch (type.toLowerCase()) {
        case "pdf":
            folder = "pdf";
            break;
        case "video":
            folder = "videos";
            break;
        case "image":
            folder = "images";
            break;
        default:
            return ResponseEntity.badRequest().body(null);
    }

    Path fileLocation = Paths.get(uploadRoot, folder, filePath).normalize();

    System.out.println("Trying to download from: " + fileLocation);

    Resource resource = new UrlResource(fileLocation.toUri());

    if (!resource.exists() || !resource.isReadable()) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
}

	@GetMapping("/stream")
public ResponseEntity<Resource> streamVideo(
        @RequestParam("filename") String filename
) throws IOException {

    Path videoPath = Paths.get(uploadRoot, "videos", filename);
    Resource resource = new UrlResource(videoPath.toUri());

    if (!resource.exists()) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType("video/mp4"))
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
            .body(resource);
}



	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadMaterial(@RequestParam String title, @RequestParam("type") String type,
			@RequestParam Long teacherId, @RequestParam String className, @RequestParam String subjectName,
			@RequestParam("file") MultipartFile file) {

		try {

			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File cannot be empty");
			}

			String originalFileName = file.getOriginalFilename();
			String extension = "";

			if (originalFileName != null && originalFileName.contains(".")) {
				extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
			}

			LessonMaterial material = new LessonMaterial();
			material.setTitle(title);
			material.setType(type);
			material.setTeacherId(teacherId);
			material.setClassName(className);
			material.setSubjectName(subjectName);

			/* ================= IMAGE VALIDATION ================= */
			if ("Image".equalsIgnoreCase(type)) {

				if (!(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png"))) {
					return ResponseEntity.badRequest().body("Only JPG, JPEG, PNG images are allowed");
				}

				String imgName = UUID.randomUUID() + "_" + originalFileName;
				Path imgPath = Paths.get(uploadRoot, "images", imgName);
				Files.createDirectories(imgPath.getParent());
				Files.copy(file.getInputStream(), imgPath, StandardCopyOption.REPLACE_EXISTING);

				material.setImagePath("/uploads/images/" + imgName);
			}

			/* ================= VIDEO VALIDATION ================= */
			else if ("Video".equalsIgnoreCase(type)) {

				if (!extension.equals("mp4")) {
					return ResponseEntity.badRequest().body("Only MP4 videos are allowed");
				}

				String vidName = UUID.randomUUID() + "_" + originalFileName;
				Path vidPath = Paths.get(uploadRoot, "videos", vidName);
				Files.createDirectories(vidPath.getParent());
				Files.copy(file.getInputStream(), vidPath, StandardCopyOption.REPLACE_EXISTING);

				material.setVideoPath("/uploads/videos/" + vidName);
			}

			/* ================= PDF VALIDATION ================= */
			else if ("PDF".equalsIgnoreCase(type)) {

				if (!extension.equals("pdf")) {
					return ResponseEntity.badRequest().body("Only PDF files are allowed");
				}

				String pdfName = UUID.randomUUID() + "_" + originalFileName;
				Path pdfPath = Paths.get(uploadRoot, "pdfs", pdfName);
				Files.createDirectories(pdfPath.getParent());
				Files.copy(file.getInputStream(), pdfPath, StandardCopyOption.REPLACE_EXISTING);

				material.setPdfPath("/uploads/pdfs/" + pdfName);
			}

			else {
				return ResponseEntity.badRequest().body("Invalid file type selected");
			}

			repo.save(material);
			return ResponseEntity.ok(material);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
		}
	}

	@GetMapping("/videos/{fileName}")
	public ResponseEntity<Resource> getVideo(@PathVariable String fileName) throws IOException {

		Path path = Paths.get("uploads/videos/" + fileName);
		Resource resource = new UrlResource(path.toUri());

		return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4")).body(resource);
	}

	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<?> getMaterialsByTeacher(@PathVariable Long teacherId) {

		try {
			List<LessonMaterial> list = repo.findByTeacherId(teacherId);

			return ResponseEntity.ok(list);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to fetch materials");
		}
	}

	@GetMapping("/getMaterailDetails")
	public ResponseEntity<?> getMaterialDetails(@RequestParam String subjectName, @RequestParam String className) {

		System.out.println("Subject: " + subjectName);
		System.out.println("Class: " + className);

		List<LessonMaterial> materials = repo.findBySubjectNameAndClassName(subjectName, className);

		return ResponseEntity.ok(materials);
	}

}
