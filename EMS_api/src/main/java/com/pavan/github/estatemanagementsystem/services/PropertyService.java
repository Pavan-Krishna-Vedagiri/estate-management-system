package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.repositories.PropertyRepo;
import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepo propertyRepo;

    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public List<Property> getAllProperties() {
        return propertyRepo.findAllProperties();
    }

    public Property getPropertyById(String propertyId) {
        return propertyRepo.findByPropertyId(propertyId);
    }

    public List<Room> getAllRooms(String propertyId) {
        return propertyRepo.getRooms(propertyId);
    }

    public Boolean deletePropertyById(String propertyId) {
        return propertyRepo.deleteProperty(propertyId);
    }

    public Boolean updateProperty(Property property) {
        return propertyRepo.updateProperty(property);
    }

}
