package com.example.demo.controllers;


import com.example.demo.models.Performance;
import com.example.demo.repositories.PerformanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@RestController
public class PerformanceRest {

    @Resource
    PerformanceRepository performanceRepo;

    @RequestMapping("/get-all-performances")
    public Collection<Performance> getAllPerformances() {
        return performanceRepo.findAll(Sort.by("dateTimes[0]"));
//        return (Collection<Performance>) performanceRepo.findAll();


    }

    @PostMapping("/delete-performance")
    public Collection<Performance> deletePerformanceFromDatabase(@RequestBody Performance performanceToDelete) throws IOException {

        if (performanceRepo.existsById(performanceToDelete.getId())) {
            performanceRepo.deleteById(performanceToDelete.getId());
        }
        return (Collection<Performance>) performanceRepo.findAll();
    }
}
