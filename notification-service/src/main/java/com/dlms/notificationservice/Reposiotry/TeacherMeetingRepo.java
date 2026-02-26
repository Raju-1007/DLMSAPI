package com.dlms.notificationservice.Reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlms.notificationservice.model.TeacherMeeting;

public interface TeacherMeetingRepo  extends JpaRepository<TeacherMeeting, Long>{

}
