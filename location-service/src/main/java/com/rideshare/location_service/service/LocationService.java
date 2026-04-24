package com.rideshare.location_service.service;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.rideshare.location_service.dto.DriverLocationRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationService {

    private final RedisTemplate<String, String> redisTemplate;
    // Redis key for all driver locations
    private static final String DRIVERS_GEO_KEY = "drivers:locations";

    // update driver location in redis
    // called every 3 second by drivers phone
    // maps to redis GEOADD command

    public void updateDriverLocation(DriverLocationRequest driverLocationRequest){
        log.info("updating location for driver : {}", driverLocationRequest.getDriverId());

        Point driverpoint = new Point(
            driverLocationRequest.getLongitude(), 
            driverLocationRequest.getLatitude()
        );
       redisTemplate.opsForGeo().add(DRIVERS_GEO_KEY, driverpoint,driverLocationRequest.getDriverId()) 
    }
}
