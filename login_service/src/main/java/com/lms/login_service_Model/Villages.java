package com.lms.login_service_Model;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import com.lms.login_service_Model.Mandal;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SuppressWarnings("unused")
@Entity
@Table(name="village_details")
public class Villages {
	
	@Id
    @Column(name = "village_id", nullable = false)
    private Long villageId;
    
  

    @NotBlank(message = "Village name is required")
    @Size(min = 3, max = 150, message = "Village name must be between 3 and 150 characters")
    @Column(name = "village_name", nullable = false)
    private String villageName;
    
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandal_id", nullable = true)
    private Mandal mandal;
    
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
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
    
    public  Villages() {
    	super();
    }

	public Villages(Long villageId,
			@NotBlank(message = "Village name is required") @Size(min = 3, max = 150, message = "Village name must be between 3 and 150 characters") String villageName,
			Mandal mandal, District district,Timestamp createdAt, Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
		super();
		this.villageId = villageId;
		this.villageName = villageName;
		this.mandal = mandal;
		this.district=district;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Mandal getMandal() {
		return mandal;
	}

	public void setMandal(Mandal mandal) {
		this.mandal = mandal;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
    


}
