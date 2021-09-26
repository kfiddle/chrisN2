package com.example.demo.controllers;

import com.example.demo.models.Instrument;
import com.example.demo.models.Performance;
import com.example.demo.repositories.InstrumentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class InstrumentRest {

    @Resource
    InstrumentRepository instrumentRepo;


    @RequestMapping("/get-all-instruments")
    public Collection<Instrument> getAllInstruments() {
        return (Collection<Instrument>) instrumentRepo.findAll();
    }

}
