package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.RoomBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomBookingsRepo extends JpaRepository<RoomBookings, String> {

    public Optional<RoomBookings> findByRoomIdAndResidentId(String roomId, String residentId);

    public List<RoomBookings> findByRoomId(String roomId);

}
