package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.dto.ResidentsListDto;
import com.pavan.github.estatemanagementsystem.dto.ResidentDto;
import com.pavan.github.estatemanagementsystem.entities.Resident;
import com.pavan.github.estatemanagementsystem.repositories.ResidentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResidentService {

    private final ResidentRepo residentRepo;
    private final ObjectMapper objectMapper;
    private final SequenceService sequenceService;

    public ResidentService(ResidentRepo residentRepo, ObjectMapper objectMapper, SequenceService sequenceService) {
        this.residentRepo = residentRepo;
        this.objectMapper = objectMapper;
        this.sequenceService = sequenceService;
    }

    public ResponseEntity<CommonResponseDto<ResidentsListDto>> findAll() {

        Pageable pageable = PageRequest.of(0, 10);
        Page<Resident> residents = residentRepo.findAll(pageable);
        System.out.printf("""
                page :{
                    totalPages : %s,
                    totalElements : %s,
                    pageNumber : %s,
                    pageSize : %s
                }
                """, residents.getTotalPages(), residents.getTotalElements(), residents.getNumber(), residents.getSize());
        ResidentsListDto residentsListDto = new ResidentsListDto();
        List<ResidentDto> responseDtos = objectMapper.convertValue(residents.get(), new TypeReference<List<ResidentDto>>(){});
        residentsListDto.setResidents(responseDtos);
        CommonResponseDto<ResidentsListDto> response = CommonResponseDto.<ResidentsListDto>builder()
                .responseId(UUID.randomUUID().toString())
                .status(ResponseConstants.SUCCESS)
                .message("Residents fetch successfully")
                .timestamp(new Date(System.currentTimeMillis()))
                .data(residentsListDto)
                .build();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<CommonResponseDto<ResidentDto>> findById(String id) {
        Resident resident = residentRepo.findById(id).orElse(null);
        ResidentDto residentDto = objectMapper.convertValue(resident, ResidentDto.class);
        CommonResponseDto<ResidentDto> response = CommonResponseDto.<ResidentDto>builder()
                .responseId(UUID.randomUUID().toString())
                .status(ResponseConstants.SUCCESS)
                .message("Resident fetch successfully")
                .timestamp(new Date(System.currentTimeMillis()))
                .data(residentDto)
                .build();
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<CommonResponseDto<Map<String,String>>> addResident(ResidentDto resident) {

        Map<String,String> data = new HashMap<>();

        Resident newResident = objectMapper.convertValue(resident, Resident.class);
        newResident.setId(sequenceService.nextSequenceValue("RESIDENT_SEQUENCE"));
        newResident.getAddress().setAddressId(sequenceService.nextSequenceValue("ADDRESS_SEQUENCE"));
        newResident.setCreatedStamp(new Date());
        newResident.setLastUpdatedStamp(new Date());
        residentRepo.save(newResident);
        CommonResponseDto<Map<String, String>> response = CommonResponseDto.<Map<String, String>>builder()
                .responseId(UUID.randomUUID().toString())
                .status(ResponseConstants.SUCCESS)
                .message("Resident created successfully")
                .timestamp(new Date(System.currentTimeMillis()))
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    public ResponseEntity<CommonResponseDto<String>> updateResident(String id, ResidentDto residentDto) {
        Optional<Resident> optionalResident = residentRepo.findById(id);
        String responseMessage = "Update Resident Failed";
        if (optionalResident.isPresent()) {
            Resident resident = optionalResident.get();
            resident.setId(id);
            resident = objectMapper.convertValue(residentDto, Resident.class);
            residentRepo.save(resident);
            responseMessage = "Update Resident Successfully";
        }
        CommonResponseDto<String> responseDto = CommonResponseDto.<String>builder()
                .responseId(UUID.randomUUID().toString())
                .status(ResponseConstants.SUCCESS)
                .message(responseMessage)
                .timestamp(new Date())
                .build();
        return ResponseEntity.ok(responseDto);
    }

}
