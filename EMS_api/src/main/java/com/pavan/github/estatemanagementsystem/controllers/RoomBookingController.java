package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.ResidentDto;
import com.pavan.github.estatemanagementsystem.dto.RoomBookingsDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.Resident;
import com.pavan.github.estatemanagementsystem.entities.RoomBookings;
import com.pavan.github.estatemanagementsystem.repositories.RoomBookingsRepo;
import com.pavan.github.estatemanagementsystem.services.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.BOOKINGS_URL)
@CrossOrigin(origins = "*")
public class RoomBookingController {

    @Autowired
    private RoomBookingService roomBookingService;

    @GetMapping("/{roomId}")
    public ResponseEntity<CommonResponseDto<List<RoomBookingsDto>>> getBookingDetail(@PathVariable String roomId) {
        return roomBookingService.getBookingDetails(roomId);
    }
}
