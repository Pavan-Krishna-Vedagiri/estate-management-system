package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.Room;
import com.pavan.github.estatemanagementsystem.repositories.PropertyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepo propertyRepo;

    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public List<Property> getAllProperties() {
        return propertyRepo.findAll();
    }

    public Property getPropertyById(String propertyId) {
        return propertyRepo.findById(propertyId).orElse(null);
    }

    public List<Room> getAllRooms(String propertyId) {
        Optional<Property> property = propertyRepo.findById(propertyId);
        return property.map(Property::getRooms).orElse(null);
    }

    public Boolean deletePropertyById(String propertyId) {
        Property property = getPropertyById(propertyId);
        if (property != null) {
            return false;
        }else {
            propertyRepo.deleteById(propertyId);
            return true;
        }
    }

    public Boolean updateProperty(Property property) {
        propertyRepo.save(property);
        return true;
    }

    public Boolean createProperty(Property property) {
        propertyRepo.save(property);
        return true;
    }

}
