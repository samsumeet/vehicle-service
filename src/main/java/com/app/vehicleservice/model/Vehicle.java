package com.app.vehicleservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Table(name = "vehicle")
@Entity
public class Vehicle {

  @Id
  private String id;
}
