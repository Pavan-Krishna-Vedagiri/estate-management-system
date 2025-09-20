package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.modals.PG;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pg")
public class PgController {

    @GetMapping(path={"", "/"})
    public List<PG> getAllPGs(){
        List<PG> pgList = List.of(
                new PG("PG101", "Sunshine Residency"),
                new PG("PG102", "Green Nest"),
                new PG("PG103", "Urban Stay"),
                new PG("PG104", "Comfort Living"),
                new PG("PG105", "Blue Horizon"),
                new PG("PG106", "Elite Homes"),
                new PG("PG107", "Maple Heights"),
                new PG("PG108", "Serene Shelter"),
                new PG("PG109", "Metro Habitat"),
                new PG("PG110", "Tranquil Towers")
        );

        return pgList;
    }
}
