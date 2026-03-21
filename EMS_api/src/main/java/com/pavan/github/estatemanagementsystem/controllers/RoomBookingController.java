package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.CommonResponseTO;
import com.pavan.github.estatemanagementsystem.entities.RoomAvailability;
import com.pavan.github.estatemanagementsystem.services.RoomBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UrlConstants.BOOK_ROOM)
public class RoomBookingController {

    private final RoomBookingService roomBookingService;

    public RoomBookingController(RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<List<RoomAvailability>> getAvailableRooms(@PathVariable String propertyId) {
        List<RoomAvailability> roomAvailabilities = roomBookingService.getAvailableRooms(propertyId);
        return ResponseEntity.ok(roomAvailabilities);
    }

    @PutMapping("/{propertyId}/{roomId}")
    public ResponseEntity<CommonResponseTO> bookRoom(@PathVariable String propertyId, @PathVariable String roomId) {
        Boolean status = roomBookingService.bookRoom(propertyId, roomId);
        String message = "No beds available";
        if (Boolean.TRUE.equals(status)) {
            message = "Bed booked Successful";
        }
        CommonResponseTO response = CommonResponseTO.builder()
                .requestId(UUID.randomUUID().toString())
                .responseCode(ResponseConstants.SUCCESS_CODE)
                .respondedTime(LocalDateTime.now())
                .status(ResponseConstants.RESPONSE_SUCCESS)
                .responseMessage(message).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
