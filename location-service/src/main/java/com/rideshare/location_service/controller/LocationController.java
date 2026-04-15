package com.rideshare.location_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rideshare.location_service.dto.DriverLocationRequest;
import com.rideshare.location_service.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/locations")
@Slf4j
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    // driver 
    public ResponseEntity<String> updateDriverLocation(@RequestBody DriverLocationRequest driverLocationRequest){
        locationService.updateDriverLocation(driverLocationRequest);
        return ResponseEntity.ok("Driver location updated");
    }
}
