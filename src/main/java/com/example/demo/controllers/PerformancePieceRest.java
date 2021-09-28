package com.example.demo.controllers;

import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PerformancePieceRepository;
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


//    @PostMapping("/get-pieces-of-performance")
//    public Collection<Piece> getAllPiecesInAShow(@RequestBody Performance performance) {
//        Collection<Piece> piecesToReturn = new ArrayList<>();
//        Collection<PerformancePiece> ppsToCheck = performancePieceRepo.findAllByPerformance(performance, Sort.by("orderNumber"));
//        for (PerformancePiece pp : ppsToCheck) {
//            piecesToReturn.add(pp.getPiece());
//
//        }
//        return piecesToReturn;
//    }

    @PostMapping("/get-performance-pieces")
    public Collection<PerformancePiece> getAllPiecesInAShow(@RequestBody Performance performance) {
        return performancePieceRepo.findAllByPerformance(performance, Sort.by("orderNumber"));
    }


}
