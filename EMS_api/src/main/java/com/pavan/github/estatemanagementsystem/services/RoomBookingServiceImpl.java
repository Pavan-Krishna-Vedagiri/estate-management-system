package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.ResidentDto;
import com.pavan.github.estatemanagementsystem.dto.RoomBookingsDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.Resident;
import com.pavan.github.estatemanagementsystem.entities.Room;
import com.pavan.github.estatemanagementsystem.entities.RoomBookings;
import com.pavan.github.estatemanagementsystem.repositories.ResidentRepo;
import com.pavan.github.estatemanagementsystem.repositories.RoomBookingsRepo;
import com.pavan.github.estatemanagementsystem.repositories.RoomRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    private final RoomBookingsRepo roomBookingsRepo;
    private final ObjectMapper objectMapper;
    private final RoomRepo roomRepo;
    private final SequenceService sequenceService;
    private final ResidentRepo residentRepo;

    public RoomBookingServiceImpl(RoomBookingsRepo roomBookingsRepo, ObjectMapper objectMapper, RoomRepo roomRepo, SequenceService sequenceService, ResidentRepo residentRepo) {
        this.roomBookingsRepo = roomBookingsRepo;
        this.objectMapper = objectMapper;
        this.roomRepo = roomRepo;
        this.sequenceService = sequenceService;
        this.residentRepo = residentRepo;
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

    @Override
    public ResponseEntity<CommonResponseDto<String>> bookRoom(String roomId, ResidentDto residentDto) {
        Optional<Room> room = roomRepo.findByRoomIdAndPropertyId(roomId, "PROP001");
        Resident resident = objectMapper.convertValue(residentDto, Resident.class);
        String responseMessage = "Room booked successfully";
        if (room.isPresent()) {
            Room roomEo =  room.get();
            if (roomEo.getAvailableBeds() > 0){
                int availableBeds = roomEo.getAvailableBeds();
                RoomBookings roomBookingsEo = new RoomBookings();
                roomBookingsEo.setRoomId(roomId);
                roomBookingsEo.setPropertyId("PROP001");
                roomBookingsEo.setBookingId(sequenceService.nextSequenceValue("BOOKING_SEQUENCE"));
                roomBookingsEo.setStatus("ACTIVE");
                roomBookingsEo.setStartDate(new Timestamp(new Date().getTime()));
                roomBookingsEo.setRentAmount("7500");
                roomBookingsEo.setCreatedStamp(new Timestamp(new Date().getTime()));
                roomBookingsEo.setLastUpdatedStamp(new Timestamp(new Date().getTime()));
                roomEo.setAvailableBeds(availableBeds -1);
                resident.setId(sequenceService.nextSequenceValue("RESIDENT_SEQUENCE"));
                roomBookingsEo.setResidentId(resident.getId());
                residentRepo.save(resident);
                roomBookingsRepo.save(roomBookingsEo);
                roomRepo.save(roomEo);
            }else  {
                responseMessage = "Room has no free beds";
            }
        }else {
            responseMessage = "Room not found";
        }

        CommonResponseDto<String> responseDto = CommonResponseDto.<String>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .timestamp(new Date())
                .data(responseMessage)
                .status(ResponseConstants.SUCCESS)
                .build();
        return ResponseEntity.ok(responseDto);
    };

    public ResponseEntity<CommonResponseDto<String>> getTotalRevenue() {
        String responseMessage = "No revenue";
        String revenue = roomBookingsRepo.findTotalRevenue();
        CommonResponseDto<String> responseDto = CommonResponseDto.<String>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .timestamp(new Date())
                .status(ResponseConstants.SUCCESS)
                .data(revenue == null ? "0" : revenue)
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
