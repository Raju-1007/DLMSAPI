package com.lms.login_service_Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="teacher_details")
public class TeacherDetails {
	@Id
    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;
    
  

    @NotBlank(message = "teacher name is required")
    @Size(min = 3, max = 150, message = "teacher name must be between 3 and 150 characters")
    @Column(name = "teacher_name", nullable = false)
    private String teacherName;
    
    @NotBlank(message = "teacher email is required")
    @Size(min = 3, max = 150, message = "teacher email must be between 3 and 150 characters")
    @Column(name = "teacher_email", nullable = false)
    private String teacheremail;
    
    
    @NotBlank(message = "teacher phone is required")
    @Size(min = 3, max = 150, message = "teacher phone must be between 3 and 150 characters")
    @Column(name = "teacher_phone", nullable = false)
    private String teacher_Phone;
    
    @NotBlank(message = "teacher address is required")
    @Size(min = 3, max = 150, message = "teacher address must be between 3 and 150 characters")
    @Column(name = "teacher_address", nullable = false)
    private String teacherAddress;
    
    @NotBlank(message = "teacher name is required")
    @Size(min = 3, max = 150, message = "teacher qualification must be between 3 and 150 characters")
    @Column(name = "teacher_qualification", nullable = false)
    private String teacherQualification;
    
    @NotBlank(message = "teacher desnignation is required")
    @Size(min = 3, max = 150, message = "teacher name must be between 3 and 150 characters")
    @Column(name = "teacher_desgination", nullable = false)
    private String teacherDesgination;
    
    
    @Column(name = "created_at", updatable = false)
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
    
    public TeacherDetails() {
    	super();
    }

	public TeacherDetails(Long teacherId,
			@NotBlank(message = "teacher name is required") @Size(min = 3, max = 150, message = "teacher name must be between 3 and 150 characters") String teacherName,
			@NotBlank(message = "teacher email is required") @Size(min = 3, max = 150, message = "teacher email must be between 3 and 150 characters") String teacheremail,
			@NotBlank(message = "teacher phone is required") @Size(min = 3, max = 150, message = "teacher phone must be between 3 and 150 characters") String teacher_Phone,
			@NotBlank(message = "teacher address is required") @Size(min = 3, max = 150, message = "teacher address must be between 3 and 150 characters") String teacherAddress,
			@NotBlank(message = "teacher name is required") @Size(min = 3, max = 150, message = "teacher qualification must be between 3 and 150 characters") String teacherQualification,
			@NotBlank(message = "teacher desnignation is required") @Size(min = 3, max = 150, message = "teacher name must be between 3 and 150 characters") String teacherDesgination,
			Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacheremail = teacheremail;
		this.teacher_Phone = teacher_Phone;
		this.teacherAddress = teacherAddress;
		this.teacherQualification = teacherQualification;
		this.teacherDesgination = teacherDesgination;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacheremail() {
		return teacheremail;
	}

	public void setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
	}

	public String getTeacher_Phone() {
		return teacher_Phone;
	}

	public void setTeacher_Phone(String teacher_Phone) {
		this.teacher_Phone = teacher_Phone;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherQualification() {
		return teacherQualification;
	}

	public void setTeacherQualification(String teacherQualification) {
		this.teacherQualification = teacherQualification;
	}

	public String getTeacherDesgination() {
		return teacherDesgination;
	}

	public void setTeacherDesgination(String teacherDesgination) {
		this.teacherDesgination = teacherDesgination;
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
