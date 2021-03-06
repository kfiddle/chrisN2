package com.example.demo.controllers;


import com.example.demo.models.DateTime;
import com.example.demo.models.Performance;
import com.example.demo.repositories.PerformanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class PerformanceRest {

    @Resource
    PerformanceRepository performanceRepo;

    @RequestMapping("/get-all-performances")
    public Collection<Performance> getAllPerformances() {
        List<Performance> sortedPerformances = new ArrayList<>((Collection<Performance>) performanceRepo.findAll());
        Collections.sort(sortedPerformances);
        return sortedPerformances;
    }

    @PostMapping("/add-performance")
    public Long addPerformanceToDatabase(@RequestBody Performance performanceToAdd) throws IOException {

        try {
            if (!performanceRepo.existsByTitle(performanceToAdd.getTitle())) {
                Performance newPerformance = new Performance();
                newPerformance.setAllProps(performanceToAdd);
                performanceRepo.save(newPerformance);
                System.out.println(newPerformance.getTitle());
                return newPerformance.getId();
            }

        } catch (
                Exception error) {
            error.printStackTrace();

        }
        return null;
    }

    @PostMapping("/delete-performance")
    public Collection<Performance> deletePerformanceFromDatabase(@RequestBody Performance performanceToDelete) throws IOException {

        if (performanceRepo.existsById(performanceToDelete.getId())) {
            performanceRepo.deleteById(performanceToDelete.getId());
        }
        return (Collection<Performance>) performanceRepo.findAll();
    }
}
