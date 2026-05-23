package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.RoomBookingsDto;
import com.pavan.github.estatemanagementsystem.dto.RoomDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.Room;
import com.pavan.github.estatemanagementsystem.entities.RoomBookings;
import com.pavan.github.estatemanagementsystem.repositories.ResidentRepo;
import com.pavan.github.estatemanagementsystem.repositories.RoomBookingsRepo;
import com.pavan.github.estatemanagementsystem.repositories.RoomRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepo roomRepo;
    private final ObjectMapper objectMapper;
    private final ResidentRepo residentRepo;
    private final RoomBookingsRepo roomBookingsRepo;

    public RoomServiceImpl(RoomRepo roomRepo, ObjectMapper objectMapper, ResidentRepo residentRepo, RoomBookingsRepo roomBookingsRepo) {
        this.roomRepo = roomRepo;
        this.objectMapper = objectMapper;
        this.residentRepo = residentRepo;
        this.roomBookingsRepo = roomBookingsRepo;
    }

    @Override
    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllRooms(String propertyId) {
        List<Room> rooms = roomRepo.findByPropertyId(propertyId);
        String responseMessage = "Rooms fetched successfully";
        List<RoomDto> roomDtos = objectMapper.convertValue(rooms, new TypeReference<List<RoomDto>>() {
        });

        CommonResponseDto<List<RoomDto>> responseDto = CommonResponseDto.<List<RoomDto>>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .timestamp(new Date())
                .status(ResponseConstants.SUCCESS)
                .data(roomDtos).build();
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllAvailableRooms(String propertyId) {

        List<Room> availableRooms = roomRepo.findByAvailableRooms(propertyId);
        String responseMessage = "All available fetched successfully";
        List<RoomDto> availableRoomDtos = objectMapper.convertValue(availableRooms, new TypeReference<List<RoomDto>>() {
        });
        CommonResponseDto<List<RoomDto>> responseDto = CommonResponseDto.<List<RoomDto>>builder()
                .responseId(UUID.randomUUID().toString())
                .data(availableRoomDtos)
                .timestamp(new Date())
                .status(ResponseConstants.SUCCESS)
                .message(responseMessage).build();
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto<RoomDto>> getRoomDetail(String roomId) {
        Optional<Room> room = roomRepo.findById(roomId);
        String responseMessage = "Room not found";
        RoomDto roomDto = null;
        if (room.isPresent()) {
            responseMessage = "Room found successfully";
            roomDto = objectMapper.convertValue(room.get(), RoomDto.class);
        }
        CommonResponseDto<RoomDto> responseDto = CommonResponseDto.<RoomDto>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .status(ResponseConstants.SUCCESS)
                .data(roomDto)
                .timestamp(new Date()).build();
        return ResponseEntity.ok(responseDto);
    }
}
