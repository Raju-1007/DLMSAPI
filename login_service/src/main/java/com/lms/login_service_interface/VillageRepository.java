package com.lms.login_service_interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.Villages;

public interface VillageRepository extends JpaRepository<Villages, Long>{
	
	List<Villages> findByMandal_MandalId(Long mandalId);

}
