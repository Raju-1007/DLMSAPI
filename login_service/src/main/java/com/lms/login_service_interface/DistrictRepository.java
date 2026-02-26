package com.lms.login_service_interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.login_service_Model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {

}
