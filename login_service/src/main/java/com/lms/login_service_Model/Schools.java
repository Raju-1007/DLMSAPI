package com.lms.login_service_Model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import com.lms.login_service_Model.Villages;

@SuppressWarnings("unused")
@Entity
@Table(name="schools")
public class Schools {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id", nullable = false)
    private Long schoolId;
	
	
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id", nullable = false)
    private Villages villages;

    @NotBlank(message = "School name is required")
    @Size(min = 3, max = 150, message = "School name must be between 3 and 150 characters")
    @Column(name = "school_name", nullable = false)
    private String schoolName;


    @NotBlank(message = "School type is required")
    @Column(name = "school_type", nullable = false)
    private String schoolType;
    
    @OneToMany(mappedBy = "schoolDetails", fetch = FetchType.LAZY)
    private List<Classes> classes;
    
    @NotBlank(message = "rollNo  is required")
    @Column(name = "rollNo", nullable = false)
    private String rollNo;
    
    
    
    
    @Size(max = 50, message = "School timings too long")
    @Column(name = "school_timings")
    private String schoolTimings;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address length should be less than 255")
    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mandal_id", nullable = true)
    private Mandal mandal;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id", nullable = true)
    private District district;

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
    
    public Schools() {
    	    super();
    }

	public Schools(Long schoolId, Villages villages,
			@NotBlank(message = "School name is required") @Size(min = 3, max = 150, message = "School name must be between 3 and 150 characters") String schoolName,
			@NotBlank(message = "School type is required") String schoolType, List<Classes> classes,
			@NotBlank(message = "rollNo  is required") String rollNo,
			@Size(max = 50, message = "School timings too long") String schoolTimings,
			@NotBlank(message = "Address is required") @Size(max = 255, message = "Address length should be less than 255") String address,
			Mandal mandal, District district, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy,
			Timestamp updatedBy) {
		super();
		this.schoolId = schoolId;
		this.villages = villages;
		this.schoolName = schoolName;
		this.schoolType = schoolType;
		this.classes = classes;
		this.rollNo = rollNo;
		this.schoolTimings = schoolTimings;
		this.address = address;
		this.mandal = mandal;
		this.district = district;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Villages getVillages() {
		return villages;
	}

	public void setVillages(Villages villages) {
		this.villages = villages;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getSchoolTimings() {
		return schoolTimings;
	}

	public void setSchoolTimings(String schoolTimings) {
		this.schoolTimings = schoolTimings;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Mandal getMandal() {
		return mandal;
	}

	public void setMandal(Mandal mandal) {
		this.mandal = mandal;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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