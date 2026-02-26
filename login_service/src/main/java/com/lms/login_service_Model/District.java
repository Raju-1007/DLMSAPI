package com.lms.login_service_Model;

import java.sql.Timestamp;


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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lms.login_service_Model.Mandal;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SuppressWarnings("unused")
@Entity
@Table(name="District_details")
public class District {
	
	
	@Id
    @Column(name = "district_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districId;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandal_id", nullable = true)
    private Mandal mandal;

    @NotBlank(message = "district name is required")
    @Size(min = 3, max = 150, message = "district name must be between 3 and 150 characters")
    @Column(name = "district_name", nullable = false)
    private String districtName;
    
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
    public District() {
    	super();
    }

	public District(Long districId, Mandal mandal,
			@NotBlank(message = "district name is required") @Size(min = 3, max = 150, message = "district name must be between 3 and 150 characters") String districtName,
			Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.districId = districId;
		this.mandal = mandal;
		this.districtName = districtName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getDistricId() {
		return districId;
	}

	public void setDistricId(Long districId) {
		this.districId = districId;
	}

	public Mandal getMandal() {
		return mandal;
	}

	public void setMandal(Mandal mandal) {
		this.mandal = mandal;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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