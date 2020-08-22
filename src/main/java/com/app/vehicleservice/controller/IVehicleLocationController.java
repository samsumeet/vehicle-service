package com.app.vehicleservice.controller;

import com.app.vehicleservice.model.Vehicle;
import com.app.vehicleservice.model.VehicleLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Here we define API Contract for Insert,Update and Delete Device
 */
@RestController
@RequestMapping("vehicles")
public interface IVehicleLocationController {

  @ApiOperation(value = "Vehicle Registration", notes = "Register new Vehicle", response = List.class)
  @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
  @PostMapping
  ResponseEntity registerVehicle(@RequestBody Vehicle vehicle);

  @ApiOperation(value = "Insert Product Data", notes = "Insert Product Data", response = List.class)
  @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
  @PostMapping(value = "/{id}/locations")
  ResponseEntity update(@PathVariable("id") String id, @RequestBody VehicleLocation body);

  @ApiOperation(value = "Return Product information", notes = "Return Product information", response = List.class)
  @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
  @DeleteMapping(value = "/{id}")
  ResponseEntity delete(@PathVariable("id") String id);
}
