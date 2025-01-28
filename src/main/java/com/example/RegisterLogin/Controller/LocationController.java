package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Location;
import com.example.RegisterLogin.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localisations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @PostMapping("/add")
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location locationDetails) {
        Location location = locationRepository.findById(id).orElse(null);
        if (location == null) {
            return ResponseEntity.notFound().build();
        }
        location.setName(locationDetails.getName());
        location.setPhone(locationDetails.getPhone());
        location.setCity(locationDetails.getCity());
        location.setPostalCode(locationDetails.getPostalCode());
        location.setAddress(locationDetails.getAddress());
        Location updatedLocation = locationRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id).orElse(null);
        if (location != null) {
            locationRepository.delete(location);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}