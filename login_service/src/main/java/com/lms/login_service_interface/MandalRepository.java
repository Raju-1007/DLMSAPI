package com.lms.login_service_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.login_service_Model.Mandal;

public interface MandalRepository  extends JpaRepository<Mandal, Long> {
	 List<Mandal> findByDistrict_DistricId(Long districId);
	 
	 @Query("SELECT m FROM Mandal m WHERE m.district.id = :districtId")
	 List<Mandal> findByDistrictId(@Param("districtId") Long districId);

}
