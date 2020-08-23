package com.app.vehicleservice.controller;

import com.app.vehicleservice.model.BroadcastLocationEvent;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

public interface IVehicleLocationBroadcastController {

  @MessageMapping("/vehicle.registerVehicle")
  @SendTo("/topic/public")
  public BroadcastLocationEvent registerVehicle(@Payload BroadcastLocationEvent event,
      SimpMessageHeaderAccessor headerAccessor);

  @MessageMapping("/vehicle.sendLocations")
  @SendTo("/topic/public")
  public BroadcastLocationEvent broadcastLocation(@Payload BroadcastLocationEvent event);
}
