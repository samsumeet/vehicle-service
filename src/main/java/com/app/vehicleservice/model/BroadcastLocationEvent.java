package com.app.vehicleservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BroadcastLocationEvent {

  private String id;
  private VehicleLocation location;
}
