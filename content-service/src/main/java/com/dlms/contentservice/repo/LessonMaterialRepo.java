package com.dlms.contentservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.contentservice.model.LessonMaterial;

public interface LessonMaterialRepo extends JpaRepository<LessonMaterial, Long> {
	 List<LessonMaterial> findByTeacherId(Long teacherId);
	 
	 List<LessonMaterial> findBySubjectNameAndClassName(String subjectName, String className);

}
