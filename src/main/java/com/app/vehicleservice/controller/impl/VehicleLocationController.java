package com.app.vehicleservice.controller.impl;

import com.app.vehicleservice.controller.IVehicleLocationController;
import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import com.app.vehicleservice.service.IVehicleLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleLocationController implements IVehicleLocationController {

  @Autowired
  private IVehicleLocationService vehicleLocationService;

  @Override
  public ResponseEntity registerVehicle(Vehicle vehicle) {

    vehicleLocationService.registerVehicle(vehicle);
    return ResponseEntity.accepted().build();
  }

  @Override
  public ResponseEntity insertVehicleLocations(String id, VehicleLocation vehicleLocation) {

    vehicleLocationService.insertVehicleLocations(id, vehicleLocation);
    return ResponseEntity.accepted().build();
  }


  @Override
  public ResponseEntity delete(String id) {

    vehicleLocationService.delete(id);
    return ResponseEntity.accepted().build();
  }
}
