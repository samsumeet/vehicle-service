package com.app.vehicleservice.service.impl;

import com.app.vehicleservice.model.BroadcastLocationEvent;
import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import com.app.vehicleservice.repository.VehicleLocationRepository;
import com.app.vehicleservice.repository.VehicleRepository;
import com.app.vehicleservice.service.IVehicleLocationService;

import com.app.vehicleservice.socketclient.StompClientSession;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;


@Component
public class VehicleLocationService implements IVehicleLocationService {

  @Lazy
  @Autowired
  private StompSession stompSession;

  @Autowired
  private VehicleRepository vehicleRepository;
  @Autowired
  private VehicleLocationRepository vehicleLocationRepository;

  @Override
  public void registerVehicle(final Vehicle vehicle) {
    vehicleRepository.save(vehicle);
  }

  @Override
  public void updateVehicleLocation(final String id, final VehicleLocation vehicleLocation) {
    if (vehicleRepository.existsById(id)) {
      vehicleLocation.setVehicleId(id);
      vehicleLocationRepository.save(vehicleLocation);

      BroadcastLocationEvent broadcastLocationEvent = new BroadcastLocationEvent(id,
          vehicleLocation);
      System.out.println(broadcastLocationEvent.getId());
      try {
        StompClientSession.INSTANCE.getStompSession()
            .send("/app/vehicle.sendLocations", broadcastLocationEvent);
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void deregisterVehicle(final String id) {
    if (vehicleRepository.existsById(id)) {
      vehicleRepository.deleteById(id);
    }
  }

}
