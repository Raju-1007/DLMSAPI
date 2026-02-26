package com.lms.login_service_Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Admin_Details {
	@Id
    @Column(name = "Student_id", nullable = false)
    private Long Student_id;
    
  

    @NotBlank(message = "student name is required")
    @Size(min = 3, max = 150, message = "studet_name must be between 3 and 150 characters")
    @Column(name = "student_name", nullable = false)
    private String student_Name;
    
    @NotBlank(message = "student email is required")
    @Size(min = 3, max = 150, message = "teacher email must be between 3 and 150 characters")
    @Column(name = "student_email", nullable = false)
    private String studentemail;
    
    
    @NotBlank(message = "student phone is required")
    @Size(min = 3, max = 150, message = "studdent phone must be between 3 and 150 characters")
    @Column(name = "student_phone", nullable = false)
    private String student_Phone;
    
    @NotBlank(message = "student address is required")
    @Size(min = 3, max = 150, message = "student address must be between 3 and 150 characters")
    @Column(name = "student_address", nullable = false)
    private String studentAddress;
    
    @NotBlank(message = "realtion_name is required")
    @Size(min = 3, max = 150, message = "relation_name must be between 3 and 150 characters")
    @Column(name = "relation_name", nullable = false)
    private String relation_Name;
    
    @NotBlank(message = "relation_type is required")
    @Size(min = 3, max = 150, message = "relation_type must be between 3 and 150 characters")
    @Column(name = "relation_type", nullable = false)
    private  String relation_type;
    
    @NotBlank(message = "relation_mobile is required")
    @Size(min = 3, max = 150, message = "relation_mobile must be between 3 and 150 characters")
    @Column(name = "relation_mobile", nullable = false)
    private String relation_mobile;
    
    @NotBlank(message = "relation_email is required")
    @Size(min = 3, max = 150, message = "relation_email must be between 3 and 150 characters")
    @Column(name = "relation_email", nullable = false)
    private String relation_email;
    
    @Column(name = "class_id", nullable = false)
	private Long class_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_Id", nullable = false)
    private Schools SchoolDetails;
    
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
    public Admin_Details () {
    	super();
    }

	public Admin_Details(Long student_id,
			@NotBlank(message = "student name is required") @Size(min = 3, max = 150, message = "studet_name must be between 3 and 150 characters") String student_Name,
			@NotBlank(message = "student email is required") @Size(min = 3, max = 150, message = "teacher email must be between 3 and 150 characters") String studentemail,
			@NotBlank(message = "student phone is required") @Size(min = 3, max = 150, message = "studdent phone must be between 3 and 150 characters") String student_Phone,
			@NotBlank(message = "student address is required") @Size(min = 3, max = 150, message = "student address must be between 3 and 150 characters") String studentAddress,
			@NotBlank(message = "realtion_name is required") @Size(min = 3, max = 150, message = "relation_name must be between 3 and 150 characters") String relation_Name,
			@NotBlank(message = "relation_type is required") @Size(min = 3, max = 150, message = "relation_type must be between 3 and 150 characters") String relation_type,
			@NotBlank(message = "relation_mobile is required") @Size(min = 3, max = 150, message = "relation_mobile must be between 3 and 150 characters") String relation_mobile,
			@NotBlank(message = "relation_email is required") @Size(min = 3, max = 150, message = "relation_email must be between 3 and 150 characters") String relation_email,
			Long class_id, Schools schoolDetails, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy,
			Timestamp updatedBy) {
		super();
		Student_id = student_id;
		this.student_Name = student_Name;
		this.studentemail = studentemail;
		this.student_Phone = student_Phone;
		this.studentAddress = studentAddress;
		this.relation_Name = relation_Name;
		this.relation_type = relation_type;
		this.relation_mobile = relation_mobile;
		this.relation_email = relation_email;
		this.class_id = class_id;
		SchoolDetails = schoolDetails;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(Long student_id) {
		Student_id = student_id;
	}

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}

	public String getStudent_Phone() {
		return student_Phone;
	}

	public void setStudent_Phone(String student_Phone) {
		this.student_Phone = student_Phone;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getRelation_Name() {
		return relation_Name;
	}

	public void setRelation_Name(String relation_Name) {
		this.relation_Name = relation_Name;
	}

	public String getRelation_type() {
		return relation_type;
	}

	public void setRelation_type(String relation_type) {
		this.relation_type = relation_type;
	}

	public String getRelation_mobile() {
		return relation_mobile;
	}

	public void setRelation_mobile(String relation_mobile) {
		this.relation_mobile = relation_mobile;
	}

	public String getRelation_email() {
		return relation_email;
	}

	public void setRelation_email(String relation_email) {
		this.relation_email = relation_email;
	}

	public Long getClass_id() {
		return class_id;
	}

	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}

	public Schools getSchoolDetails() {
		return SchoolDetails;
	}

	public void setSchoolDetails(Schools schoolDetails) {
		SchoolDetails = schoolDetails;
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