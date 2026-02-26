package com.dlms.contentservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlms.contentservice.model.Teacher_Profiles;

public interface TeacherProfileRepository extends JpaRepository<Teacher_Profiles, Long> {

@Query("SELECT t FROM Teacher_Profiles t WHERE t.Tecaher_id = :teacherId")
Optional<Teacher_Profiles> findByTeacherServiceId(@Param("teacherId") String teacherId);
}
