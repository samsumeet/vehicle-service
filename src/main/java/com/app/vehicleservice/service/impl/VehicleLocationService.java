package com.app.vehicleservice.service.impl;

import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import com.app.vehicleservice.repository.VehicleLocationRepository;
import com.app.vehicleservice.repository.VehicleRepository;
import com.app.vehicleservice.service.IVehicleLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleLocationService implements IVehicleLocationService {

  @Autowired
  private VehicleRepository vehicleRepository;
  @Autowired
  private VehicleLocationRepository vehicleLocationRepository;

  @Override
  public void registerVehicle(final Vehicle vehicle) {
    vehicleRepository.save(vehicle);
  }

  @Override
  public void insertVehicleLocations(final String id, final VehicleLocation vehicleLocation) {
    if (vehicleRepository.existsById(id)) {
      vehicleLocation.setVehicleId(id);
      vehicleLocationRepository.save(vehicleLocation);
    }

  }

  @Override
  public void delete(final String id) {
    vehicleRepository.deleteById(id);
  }
}
