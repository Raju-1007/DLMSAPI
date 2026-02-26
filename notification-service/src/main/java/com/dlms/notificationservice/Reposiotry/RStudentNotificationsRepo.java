package com.dlms.notificationservice.Reposiotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dlms.notificationservice.model.RStudentNotifications;

public interface RStudentNotificationsRepo extends JpaRepository<RStudentNotifications, Long> {

	List<RStudentNotifications> findByStudentId(Long studentId);
}
