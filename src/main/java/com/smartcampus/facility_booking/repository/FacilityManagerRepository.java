package com.smartcampus.facility_booking.repository;

import com.smartcampus.facility_booking.models.FacilityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityManagerRepository extends JpaRepository<FacilityManager, Long> {
}