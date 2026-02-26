package com.dlms.notificationservice.model;

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
@Table(name="classes")
public class Classes {
	
	@Id
    @Column(name = "class_id", nullable = false)
	private Long class_id;
	
	
	 @Column(name = "school_id", nullable = false)
      private Long schoolId;
	
	
	@NotBlank(message = "class name is required")
    @Size(min = 3, max = 150, message = "class name must be between 3 and 150 characters")
    @Column(name = "class_name", nullable = false)
	private String class_name;
	
	@NotBlank(message = " number_of_sections is required")
	@Column(name = "number_of_sections", nullable = false)
	private String number_of_sections;
	
	@NotBlank(message = "number_of_students is required")
	@Column(name = "number_of_students", nullable = false)
	private String number_of_students;
	
	
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
	    
	    public Classes() {
	    	super();
	    }

		public Classes(Long class_id, Long schoolId,
				@NotBlank(message = "class name is required") @Size(min = 3, max = 150, message = "class name must be between 3 and 150 characters") String class_name,
				@NotBlank(message = " number_of_sections is required") String number_of_sections,
				@NotBlank(message = "number_of_students is required") String number_of_students, Timestamp createdAt,
				Timestamp updatedAt, Timestamp createdBy, Timestamp updatedBy) {
			super();
			this.class_id = class_id;
			this.schoolId = schoolId;
			this.class_name = class_name;
			this.number_of_sections = number_of_sections;
			this.number_of_students = number_of_students;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public Long getClass_id() {
			return class_id;
		}

		public void setClass_id(Long class_id) {
			this.class_id = class_id;
		}

		public Long getSchoolId() {
			return schoolId;
		}

		public void setSchoolId(Long schoolId) {
			this.schoolId = schoolId;
		}

		public String getClass_name() {
			return class_name;
		}

		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}

		public String getNumber_of_sections() {
			return number_of_sections;
		}

		public void setNumber_of_sections(String number_of_sections) {
			this.number_of_sections = number_of_sections;
		}

		public String getNumber_of_students() {
			return number_of_students;
		}

		public void setNumber_of_students(String number_of_students) {
			this.number_of_students = number_of_students;
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
