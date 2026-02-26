package com.lms.login_service_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.Schools;

public interface SchoolsDetailsRepo  extends JpaRepository<Schools, Long>{
	
	List<Schools> findByDistrict_DistricIdAndMandal_MandalIdAndVillages_VillageId(
	        Long districtId,
	        Long mandalId,
	        Long villageId
	    );

}
