package com.lms.login_service_Model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="mandal_details")
public class Mandal {
	
	@Id
    @Column(name = "mandal_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mandalId;
    
  

    @NotBlank(message = "mandal name is required")
    @Size(min = 3, max = 150, message = "mandal name must be between 3 and 150 characters")
    @Column(name = "mandal_name", nullable = false)
    private String mandalName;
    
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
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
    public Mandal() {
    	super();
    	
    }

	public Mandal(Long mandalId,
			@NotBlank(message = "mandal name is required") @Size(min = 3, max = 150, message = "mandal name must be between 3 and 150 characters") String mandalName,
			District district, Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.mandalId = mandalId;
		this.mandalName = mandalName;
		this.district = district;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getMandalId() {
		return mandalId;
	}

	public void setMandalId(Long mandalId) {
		this.mandalId = mandalId;
	}

	public String getMandalName() {
		return mandalName;
	}

	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
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
