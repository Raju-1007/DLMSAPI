package com.dlms.notificationservice.Reposiotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.TeacherSechuduleStudentMeeings;

public interface TeacherStudentSechuduleRepo  extends JpaRepository<TeacherSechuduleStudentMeeings, Long>{
	 List<TeacherSechuduleStudentMeeings> findByStudentId(Long studentId);

}
