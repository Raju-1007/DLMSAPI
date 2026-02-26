package com.dlms.notificationservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlms.notificationservice.Reposiotry.ClassesRepo;
import com.dlms.notificationservice.Reposiotry.LoginClient;
import com.dlms.notificationservice.model.Classes;
import com.dlms.notificationservice.model.SchoolsDto;
import com.dlms.notificationservice.model.StudentClassDto;
import com.dlms.notificationservice.model.StudentClassResponseDto;

@Service
public class AssignmentService {

    @Autowired
    private 	LoginClient schoolClient;
    
    @Autowired
	private ClassesRepo classRepo;

    public SchoolsDto getSchoolDetails(Long schoolId, String token) {
        return schoolClient.getDistrict(schoolId, token);
    }
    
    public List<StudentClassResponseDto> getFullDetails(Long schoolId,String token) {
    	
//    	 Long schoolId = schoolClient.getSchoolIdByTeacher(teacherId, token);

        // 1️⃣ Login-service nundi students + classId
        List<StudentClassDto> students =
        		schoolClient.getStudents(schoolId,token);

        List<StudentClassResponseDto> result = new ArrayList<>();

        // 2️⃣ ClassId tho class details fetch
        for (StudentClassDto s : students) {

            Classes cls =
                classRepo.findById(s.getClass_id()).get();

            result.add(
                new StudentClassResponseDto(
                    s.getStudentid(),
                    s.getStudent_Name(),
                    cls.getClass_name()
                )
            );
        }
        return result;
    }
}
