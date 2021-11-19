package com.example.demo.controllers;

import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PerformancePieceRepository;
import com.example.demo.repositories.PerformanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class PerformancePieceRest {


    @Resource
    PerformancePieceRepository performancePieceRepo;

    @Resource
    PerformanceRepository performanceRepo;

    @PostMapping("/add-performance-piece/{performanceId}")
    public Collection<PerformancePiece> addPieceToPerformance(@PathVariable Long performanceId, @RequestBody Piece incomingPiece) {

        try {
            Performance performanceToFind = performanceRepo.findById(performanceId).get();
            if (!performancePieceRepo.existsByPerformanceAndPiece(performanceToFind, incomingPiece)) {
                PerformancePiece ppToAdd = new PerformancePiece(performanceToFind, incomingPiece);
                performancePieceRepo.save(ppToAdd);

                if (!incomingPiece.getOrchestration().isEmpty()) {
                    System.out.println(incomingPiece.getOrchestration().size() + "    in: " + incomingPiece.getTitle());
                }

            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<PerformancePiece>) performancePieceRepo.findAll();

    }

    @PostMapping("/get-performance-pieces")
    public Collection<PerformancePiece> getAllPiecesInAShow(@RequestBody Performance performance) {
        return performancePieceRepo.findAllByPerformance(performance, Sort.by("orderNumber"));
    }


}
