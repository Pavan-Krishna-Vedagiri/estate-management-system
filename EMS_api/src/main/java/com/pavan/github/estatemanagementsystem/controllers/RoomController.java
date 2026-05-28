package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.ResidentDto;
import com.pavan.github.estatemanagementsystem.dto.RoomDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.services.RoomBookingService;
import com.pavan.github.estatemanagementsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.ROOM_URL)
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Value("PROP001")
    private String propertyId;

    @Autowired
    private RoomBookingService roomBookingService;

    @GetMapping()
    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllRooms() {
        return roomService.getAllRooms(propertyId);
    }

    @GetMapping("{roomId}")
    public ResponseEntity<CommonResponseDto<RoomDto>> getRooms(@PathVariable String roomId) {
        return roomService.getRoomDetail(roomId);
    }

    @PostMapping("/{roomId}/book-room")
    public ResponseEntity<CommonResponseDto<String>> bookRoom(@PathVariable String roomId, @RequestBody ResidentDto residentDto) {
        return roomBookingService.bookRoom(roomId, residentDto);
    }

    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAvailableRooms(String propertyId) {
        return roomService.getAllAvailableRooms(propertyId);
    }
}
