package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.Address;
import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.Room;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PropertyRepo {

    private List<Property> properties;

    public  List<Property> getProperties() {
        return properties;
    }
    public void setProperties(List<Property> properties) {
        Address address1 = new Address(
                "ADDR001",
                "12A",
                "MG Road",
                "Bengaluru",
                "India",
                "560001"
        );

        Address address2 = new Address(
                "ADDR002",
                "45B",
                "High Street",
                "London",
                "UK",
                "SW1A 1AA"
        );

        Room room1 = new Room(
                "ROOM101",
                "101",
                3,
                "PROP001",
                "A comfy 3 sharing room"
        );

        Room room2 = new Room(
                "ROOM102",
                "102",
                3,
                "PROP001",
                "A comfy 3 sharing room"
        );

        Room room3 = new Room(
                "ROOM103",
                "103",
                3,
                "PROP001",
                "A comfy 3 sharing room"
        );

        Room room4 = new Room(
                "ROOM101",
                "101",
                3,
                "PROP002",
                "A comfy 3 sharing room"
        );

        Room room5 = new Room(
                "ROOM102",
                "102",
                3,
                "PROP002",
                "A comfy 3 sharing room"
        );

        Room room6 = new Room(
                "ROOM103",
                "103",
                3,
                "PROP002",
                "A comfy 3 sharing room"
        );

        Property property1 = new Property(
                "PROP001",
                "Sunshine Residency",
                address1,
                3,
                List.of(room1,  room2, room3),
                "OWNER001",
                "A cozy 3BHK apartment located in the heart of Bengaluru."
        );

        Property property2 = new Property(
                "PROP002",
                "Riverside Villa",
                address2,
                5,
                List.of(room4, room5, room6),
                "OWNER002",
                "Spacious villa with a beautiful riverside view in London."
        );

        properties.add(property1);
        properties.add(property2);
        this.properties = properties;
    }

    public Property findByPropertyId(String propertyId) {
        for (Property property : properties) {
            if (property.getPropertyId().equals(propertyId))
                return property;
        }
        return null;
    }

    public Boolean updateProperty(Property updProperty) {
        for (Property property : properties) {
            if (property.getPropertyId().equals(updProperty.getPropertyId())) {
                property.setAddress(updProperty.getAddress());
                property.setDescription(updProperty.getDescription());
                property.setName(updProperty.getName());
                property.setOwnerId(updProperty.getOwnerId());
                property.setNumberOfRooms(updProperty.getNumberOfRooms());
                return true;
            }
        }
        return false;
    }

    public  Boolean deleteProperty(String propertyId) {
        for (Property property : properties) {
            if (property.getPropertyId().equals(propertyId)) {
                properties.remove(property);
                return true;
            }
        }
        return false;
    }

    public  List<Room> getRooms(String propertyId) {
        for (Property property : properties) {
            if (property.getPropertyId().equals(propertyId)) {
                return property.getRooms();
            }
        }
        return Collections.emptyList();
    }

    public List<Property> findAllProperties() {
        return properties;
    }

}
