package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.dto.ResidentsListDto;
import com.pavan.github.estatemanagementsystem.dto.ResidentDto;
import com.pavan.github.estatemanagementsystem.services.ResidentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(UrlConstants.RESIDENT_URL)
@CrossOrigin(origins = "*")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDto<ResidentDto>> getResidentById(@PathVariable String id) {
        return residentService.findById(id);
    }

    @GetMapping()
    public ResponseEntity<CommonResponseDto<ResidentsListDto>> getAllResidents() {
        return residentService.findAll();
    }

    @PostMapping()
    public ResponseEntity<CommonResponseDto<Map<String, String>>> createResident(@RequestBody ResidentDto residentDto) {
        return residentService.addResident(residentDto);
    }
}

