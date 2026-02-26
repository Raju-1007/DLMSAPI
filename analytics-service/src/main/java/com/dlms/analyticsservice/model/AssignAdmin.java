package com.dlms.analyticsservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="assign_admin")
public class AssignAdmin {
	
	@Id
    @Column(name = "assignAdminId", nullable = false)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column(name = "superAdminId", nullable = false)
	private Integer superAdminId;
	 
	 @Column(name = "superAdminName", nullable = false)
    private String superAdminName;
	 
	 @Column(name = "adminName", nullable = false)
    private String adminName;
	 
	 @Column(name = "adminEmail", nullable = false)
    private String adminEmail;
	 
	 @Column(name = "adminPhone", nullable = false)
    private String adminPhone;
	 
	 @Column(name = "adminRole", nullable = false)
    private String adminRole;
	 
	 @Column(name = "districtId", nullable = false)
    private Integer districtId;
	 
	 public AssignAdmin() {
		 super();
	 }

	 public AssignAdmin(Long id, Integer superAdminId, String superAdminName, String adminName, String adminEmail,
			String adminPhone, String adminRole, Integer districtId) {
		super();
		this.id = id;
		this.superAdminId = superAdminId;
		this.superAdminName = superAdminName;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
		this.adminRole = adminRole;
		this.districtId = districtId;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public Integer getSuperAdminId() {
		 return superAdminId;
	 }

	 public void setSuperAdminId(Integer superAdminId) {
		 this.superAdminId = superAdminId;
	 }

	 public String getSuperAdminName() {
		 return superAdminName;
	 }

	 public void setSuperAdminName(String superAdminName) {
		 this.superAdminName = superAdminName;
	 }

	 public String getAdminName() {
		 return adminName;
	 }

	 public void setAdminName(String adminName) {
		 this.adminName = adminName;
	 }

	 public String getAdminEmail() {
		 return adminEmail;
	 }

	 public void setAdminEmail(String adminEmail) {
		 this.adminEmail = adminEmail;
	 }

	 public String getAdminPhone() {
		 return adminPhone;
	 }

	 public void setAdminPhone(String adminPhone) {
		 this.adminPhone = adminPhone;
	 }

	 public String getAdminRole() {
		 return adminRole;
	 }

	 public void setAdminRole(String adminRole) {
		 this.adminRole = adminRole;
	 }

	 public Integer getDistrictId() {
		 return districtId;
	 }

	 public void setDistrictId(Integer districtId) {
		 this.districtId = districtId;
	 }
	 
	 
	 
}
