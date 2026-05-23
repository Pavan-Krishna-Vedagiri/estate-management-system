package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.dto.RoomDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {

    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllRooms(String propertyId);

    public ResponseEntity<CommonResponseDto<List<RoomDto>>> getAllAvailableRooms(String propertyId);

    public ResponseEntity<CommonResponseDto<RoomDto>> getRoomDetail(String roomId);
}
