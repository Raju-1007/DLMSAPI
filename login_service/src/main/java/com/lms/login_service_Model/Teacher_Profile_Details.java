package com.lms.login_service_Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher_update_profile_details")
public class Teacher_Profile_Details {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ===== TEACHER DETAILS ===== */

    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_service_id")
    private String techerServiceId;

    /* ===== STUDENT CONTACT ===== */

    @Column(name = "teacher_email")
    private String teacherEmail;

    @Column(name = "teacher_phone")
    private String teacherPhone;

    /* ===== RELATION DETAILS ===== */

    @Column(name = "relation_name")
    private String relationName;

    @Column(name = "relation_type")
    private String relationType;

    @Column(name = "relation_mobile")
    private String relationMobile;

    @Column(name = "relation_email")
    private String relationEmail;
    
    
    @Column(name = "role")
    private String role;

    /* ===== LOCATION DETAILS ===== */

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "mandal_id")
    private Mandal mandal;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Villages village;

    /* ===== AUDIT FIELDS ===== */

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    
    

    /* ===== LIFECYCLE HOOKS ===== */

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    @Column(name = "profile_image", columnDefinition = "LONGTEXT")
    private String profileImage;
    
    public Teacher_Profile_Details() {
    	super();
    }

	public Teacher_Profile_Details(Long id, Long teacherId, String teacherName, String techerServiceId,
			String teacherEmail, String teacherPhone, String relationName, String relationType, String relationMobile,
			String relationEmail,String role, District district, Mandal mandal, Villages village, LocalDateTime createdAt,
			LocalDateTime updatedAt, String profileImage) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.techerServiceId = techerServiceId;
		this.teacherEmail = teacherEmail;
		this.teacherPhone = teacherPhone;
		this.relationName = relationName;
		this.relationType = relationType;
		this.relationMobile = relationMobile;
		this.relationEmail = relationEmail;
		this.role=role;
		this.district = district;
		this.mandal = mandal;
		this.village = village;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.profileImage=profileImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTecherServiceId() {
		return techerServiceId;
	}

	public void setTecherServiceId(String techerServiceId) {
		this.techerServiceId = techerServiceId;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getRelationMobile() {
		return relationMobile;
	}

	public void setRelationMobile(String relationMobile) {
		this.relationMobile = relationMobile;
	}

	public String getRelationEmail() {
		return relationEmail;
	}

	public void setRelationEmail(String relationEmail) {
		this.relationEmail = relationEmail;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
    
  

}