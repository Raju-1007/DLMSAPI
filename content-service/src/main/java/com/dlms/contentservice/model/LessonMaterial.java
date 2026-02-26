package com.dlms.contentservice.model;



import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson_materials")
public class LessonMaterial {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "lesson_id")
    private Long id;
	 @Column(name = "title")
    private String title;
	 @Column(name = "type")
	 private String type;
	 @Column(name = "teacherId")
	 private Long teacherId;
	 @Column(name = "imagepath")
    private String imagePath;
	 @Column(name = "className")
	 private String className;
	 @Column(name = "video_path")// only path
    private String videoPath;
	 @Column(name = "pdf_path")
	 private String pdfPath;
	 // only path
	 @Column(name = "subjectName")
	 private String subjectName;
	 @Column(name = "created_at")
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    
    @Column(name = "created_by", updatable = false)
    private Timestamp createdBy;

    @Column(name = "updated_by")
    private Timestamp updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
    
    public LessonMaterial() {
    	super();
    }

	public LessonMaterial(Long id, String title, String type, Long teacherId, String imagePath, String className,
			String videoPath, String pdfPath, String subjectName, Timestamp createdAt, Timestamp updatedAt,
			Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.teacherId = teacherId;
		this.imagePath = imagePath;
		this.className = className;
		this.videoPath = videoPath;
		this.pdfPath = pdfPath;
		this.subjectName = subjectName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Timestamp updatedBy) {
		this.updatedBy = updatedBy;
	}
    

}