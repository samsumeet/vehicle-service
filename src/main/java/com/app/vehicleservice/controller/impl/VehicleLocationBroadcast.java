package com.app.vehicleservice.controller.impl;

import com.app.vehicleservice.controller.IVehicleLocationBroadcastController;
import com.app.vehicleservice.model.BroadcastLocationEvent;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class VehicleLocationBroadcast implements IVehicleLocationBroadcastController {

  @Override
  public BroadcastLocationEvent registerVehicle(BroadcastLocationEvent event,
      SimpMessageHeaderAccessor headerAccessor) {
    // Register new vehicle in web socket session
    headerAccessor.getSessionAttributes().put("id", event.getId());
    return event;
  }

  @Override
  public BroadcastLocationEvent broadcastLocation(BroadcastLocationEvent event) {
    return event;
  }
}
