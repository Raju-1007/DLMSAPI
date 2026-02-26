package com.lms.login_service_Model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


	
	@Entity
	@Table(name="student_details")
	public class StudentDetails {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;
	    
		@Column(name = "student_id", nullable = false)
		private Long Studentid;
	  

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
	    
	    
	    @Size(min = 3, max = 150, message = "relation_email must be between 3 and 150 characters")
	    @Column(name = "relation_email", nullable = false)
	    private String relation_email;
	    
	    
	    
	    @Column(name = "schoolType", nullable = false)
	    private String schoolType;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "district_id")
	    private District district;

	    @ManyToOne
	    @JoinColumn(name = "mandal_id")
	    private Mandal mandal;

	    @ManyToOne
	    @JoinColumn(name = "village_id")
	    private Villages village;

	    @ManyToOne
	    @JoinColumn(name = "school_id")
	    private Schools schoolDetails;

	    @ManyToOne
	    @JoinColumn(name = "class_id")
	    private Classes classes;
	    
	    @Column(name = "created_at", updatable = false)
	    private Timestamp createdAt;

	    @Column(name = "updated_at")
	    private Timestamp updatedAt;
	    
	    @Column(name = "created_by", updatable = false)
	    private Timestamp createdBy;

	    @Column(name = "updated_by")
	    private Timestamp updatedBy;
	    
	    @Column(name = "profile_image", columnDefinition = "LONGTEXT")
	    private String profileImage;


	    @PrePersist
	    protected void onCreate() {
	        this.createdAt = new Timestamp(System.currentTimeMillis());;
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.updatedAt = new Timestamp(System.currentTimeMillis());
	    }
	    
	   	    
	    public StudentDetails () {
	    	super();
	    }

		public StudentDetails(Long id, Long studentid,
				@NotBlank(message = "student name is required") @Size(min = 3, max = 150, message = "studet_name must be between 3 and 150 characters") String student_Name,
				@NotBlank(message = "student email is required") @Size(min = 3, max = 150, message = "teacher email must be between 3 and 150 characters") String studentemail,
				@NotBlank(message = "student phone is required") @Size(min = 3, max = 150, message = "studdent phone must be between 3 and 150 characters") String student_Phone,
				@NotBlank(message = "student address is required") @Size(min = 3, max = 150, message = "student address must be between 3 and 150 characters") String studentAddress,
				@NotBlank(message = "realtion_name is required") @Size(min = 3, max = 150, message = "relation_name must be between 3 and 150 characters") String relation_Name,
				@NotBlank(message = "relation_type is required") @Size(min = 3, max = 150, message = "relation_type must be between 3 and 150 characters") String relation_type,
				@NotBlank(message = "relation_mobile is required") @Size(min = 3, max = 150, message = "relation_mobile must be between 3 and 150 characters") String relation_mobile,
				@Size(min = 3, max = 150, message = "relation_email must be between 3 and 150 characters") String relation_email,
				String schoolType, District district, Mandal mandal, Villages village, Schools schoolDetails,
				Classes classes, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy, String profileImage) {
			super();
			this.id = id;
			Studentid = studentid;
			this.student_Name = student_Name;
			this.studentemail = studentemail;
			this.student_Phone = student_Phone;
			this.studentAddress = studentAddress;
			this.relation_Name = relation_Name;
			this.relation_type = relation_type;
			this.relation_mobile = relation_mobile;
			this.relation_email = relation_email;
			this.schoolType = schoolType;
			this.district = district;
			this.mandal = mandal;
			this.village = village;
			this.schoolDetails = schoolDetails;
			this.classes = classes;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
			this.profileImage=profileImage;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getStudentid() {
			return Studentid;
		}

		public void setStudentid(Long studentid) {
			Studentid = studentid;
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

		public String getSchoolType() {
			return schoolType;
		}

		public void setSchoolType(String schoolType) {
			this.schoolType = schoolType;
		}

		public District getDistrict() {
			return district;
		}

		public void setDistrict(District district) {
			this.district = district;
		}

		public Mandal getMandal() {
			return mandal;
		}

		public void setMandal(Mandal mandal) {
			this.mandal = mandal;
		}

		public Villages getVillage() {
			return village;
		}

		public void setVillage(Villages village) {
			this.village = village;
		}

		public Schools getSchoolDetails() {
			return schoolDetails;
		}

		public void setSchoolDetails(Schools schoolDetails) {
			this.schoolDetails = schoolDetails;
		}

		public Classes getClasses() {
			return classes;
		}

		public void setClasses(Classes classes) {
			this.classes = classes;
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

		public String getProfileImage() {
			return profileImage;
		}

		public void setProfileImage(String profileImage) {
			this.profileImage = profileImage;
		}
		
	    
	    

	}