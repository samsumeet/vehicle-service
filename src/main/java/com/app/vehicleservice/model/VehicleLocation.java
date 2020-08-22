package com.app.vehicleservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "vehicle_location")
@Entity
public class VehicleLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String vehicleId;
  private double lat;
  private double lng;
  private String at;
  //In Angles
  private String bearingLocation;
}
