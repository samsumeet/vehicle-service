package com.app.vehicleservice.service;

import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import org.springframework.stereotype.Service;

@Service
public interface IVehicleLocationService {

  void registerVehicle(final Vehicle vehicle);

  void insertVehicleLocations(final String id, final VehicleLocation vehicleLocation);

  void delete(final String id);
}
