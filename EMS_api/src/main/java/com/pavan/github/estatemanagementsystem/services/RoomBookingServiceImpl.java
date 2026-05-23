package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.RoomBookingsDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.RoomBookings;
import com.pavan.github.estatemanagementsystem.repositories.RoomBookingsRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    private final RoomBookingsRepo roomBookingsRepo;
    private final ObjectMapper objectMapper;

    public RoomBookingServiceImpl(RoomBookingsRepo roomBookingsRepo, ObjectMapper objectMapper) {
        this.roomBookingsRepo = roomBookingsRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<CommonResponseDto<List<RoomBookingsDto>>> getBookingDetails(String roomId) {

        List<RoomBookings> bookings = roomBookingsRepo.findByRoomId(roomId);
        List<RoomBookingsDto> bookingDtos = null;
        String responseMessage = "No bookings";
        if (bookings != null && !bookings.isEmpty()) {
            bookingDtos = objectMapper.convertValue(bookings, new TypeReference<List<RoomBookingsDto>>(){});
            responseMessage = "Room bookings fetched successfully";
        }
        CommonResponseDto<List<RoomBookingsDto>> responseDto = CommonResponseDto.<List<RoomBookingsDto>>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .timestamp(new Date())
                .status(ResponseConstants.SUCCESS)
                .data(bookingDtos).build();
        return ResponseEntity.ok(responseDto);
    }
}
