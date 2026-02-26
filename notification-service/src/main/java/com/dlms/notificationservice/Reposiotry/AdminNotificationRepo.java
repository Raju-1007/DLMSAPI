package com.dlms.notificationservice.Reposiotry;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.AdminNotification;

public interface AdminNotificationRepo  extends JpaRepository<AdminNotification, Long> {
	
	
	 Page<AdminNotification> findBySendTo(String sendTo, Pageable pageable);

	    Page<AdminNotification> findByTeacherId(Long teacherId, Pageable pageable);

		Page<AdminNotification> findAll(Pageable pageable);


}
