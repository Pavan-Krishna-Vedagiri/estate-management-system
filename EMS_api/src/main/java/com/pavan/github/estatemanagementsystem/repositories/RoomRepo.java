package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, String> {

    @Query("SELECT r FROM Room r WHERE r.availableBeds <> 0 AND r.propertyId =:propertyId")
    List<Room> findByAvailableRooms(@Param("propertyId") String propertyId);

    List<Room> findByPropertyId(String propertyId);

    Optional<Room> findByRoomIdAndPropertyId(String roomId, String propertyId);
}
