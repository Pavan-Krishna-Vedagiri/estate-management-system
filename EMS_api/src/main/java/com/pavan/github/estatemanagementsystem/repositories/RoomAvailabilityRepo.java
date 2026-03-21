package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.RoomAvailability;
import com.pavan.github.estatemanagementsystem.entities.RoomAvailabilityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomAvailabilityRepo extends JpaRepository<RoomAvailability, RoomAvailabilityId> {

    @Query(value = "SELECT ra FROM room_availability ra WHERE ra.propertyId = :propertyId AND ra.bedsAvailable > 0")
    List<RoomAvailability> findAvailableRooms(@Param("propertyId") String propertyId);

    @Transactional
    @Modifying
    @Query("UPDATE room_availability ra " +
            "SET ra.bedsAvailable = ra.bedsAvailable - 1 " +
            "WHERE ra.propertyId = :propertyId AND ra.roomId = :roomId AND ra.bedsAvailable > 0")
    int updateBedAvailability(@Param("propertyId") String propertyId,@Param("roomId") String roomId);
}