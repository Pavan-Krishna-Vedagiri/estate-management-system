package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.RoomDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
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

    @GetMapping()
    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllRooms() {
        return roomService.getAllRooms(propertyId);
    }

    @GetMapping("{roomId}")
    public ResponseEntity<CommonResponseDto<RoomDto>> getRooms(@PathVariable String roomId) {
        return roomService.getRoomDetail(roomId);
    }

    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAvailableRooms(String propertyId) {
        return roomService.getAllAvailableRooms(propertyId);
    }
}
