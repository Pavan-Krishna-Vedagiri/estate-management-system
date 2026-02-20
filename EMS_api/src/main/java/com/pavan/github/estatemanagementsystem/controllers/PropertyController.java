package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.Room;
import com.pavan.github.estatemanagementsystem.services.PropertyService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller(UrlConstants.PROPERTIES)
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public Property getPropertyById(String id) {
        return propertyService.getPropertyById(id);
    }

    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    public List<Room> getRooms(String propertyId) {
        return propertyService.getAllRooms(propertyId);
    }
}
