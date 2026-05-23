package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.dto.RoomBookingsDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomBookingService {

    public ResponseEntity<CommonResponseDto<List<RoomBookingsDto>>> getBookingDetails(String roomId);

}
