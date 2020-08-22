package com.app.vehicleservice.service;

import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import org.springframework.stereotype.Service;

@Service
public interface IVehicleLocationService {

  void insert(Vehicle vehicle);

  void update(String id, VehicleLocation vehicleLocation);

  void delete(String id);
}
