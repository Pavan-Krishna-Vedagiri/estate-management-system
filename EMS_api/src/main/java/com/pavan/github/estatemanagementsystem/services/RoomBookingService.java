package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.dto.RoomAvailabilityTo;
import com.pavan.github.estatemanagementsystem.entities.Property;
import com.pavan.github.estatemanagementsystem.entities.RoomAvailability;
import com.pavan.github.estatemanagementsystem.entities.RoomAvailabilityId;
import com.pavan.github.estatemanagementsystem.repositories.PropertyRepo;
import com.pavan.github.estatemanagementsystem.repositories.RoomAvailabilityRepo;
import com.pavan.github.estatemanagementsystem.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomBookingService {

    private final PropertyRepo propertyRepo;
    private final UserRepo userRepo;
    private final RoomAvailabilityRepo roomAvialabiltyRepo;


    public RoomBookingService(PropertyRepo propertyRepo, UserRepo userRepo, RoomAvailabilityRepo roomAvialabiltyRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.roomAvialabiltyRepo = roomAvialabiltyRepo;
    }

    public List<RoomAvailability> getAvailableRooms(String propertyId) {

        Optional<Property> property = propertyRepo.findById(propertyId);
        if (property.isPresent()) {
            return roomAvialabiltyRepo.findAvailableRooms(propertyId);
        }
        return null;
    }

    public Boolean bookRoom(String propertyId, String roomId) {
        RoomAvailabilityId roomAvailabilityId = new RoomAvailabilityId(propertyId, roomId);
        Optional<RoomAvailability> roomAvailability = roomAvialabiltyRepo.findById(roomAvailabilityId);
        int updated = 0;
        if (roomAvailability.isPresent()) {
            updated = roomAvialabiltyRepo.updateBedAvailability(propertyId, roomId);
        }
        return updated != 0;
    }

}
