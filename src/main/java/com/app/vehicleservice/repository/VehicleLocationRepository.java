package com.app.vehicleservice.repository;

import com.app.vehicleservice.model.VehicleLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationRepository extends JpaRepository<VehicleLocation, Long> {

}
