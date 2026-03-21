package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.Room;
import com.pavan.github.estatemanagementsystem.services.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.PROPERTIES)
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable("id") String propertyId) {
        return propertyService.getPropertyById(propertyId);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    public List<Room> getRooms(String propertyId) {
        return propertyService.getAllRooms(propertyId);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePropertyById(@PathVariable("id") String propertyId) {
        return propertyService.deletePropertyById(propertyId);
    }

    @PostMapping
    public boolean createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

}
