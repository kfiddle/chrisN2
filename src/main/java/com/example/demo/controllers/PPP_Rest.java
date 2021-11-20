package com.example.demo.controllers;


import com.example.demo.junctionTables.PInChair;
import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.repositories.PerformancePieceRepository;
import com.example.demo.repositories.PerformancePiece_PlayerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class PPP_Rest {

    @Resource
    PerformancePiece_PlayerRepository pppRepo;

    @Resource
    PerformancePieceRepository performancePieceRepo;


    @PostMapping("/add-ppp")
    public Collection<PerformancePiece_Player> addPPPToDatabase(@RequestBody PerformancePiece_Player incomingPPP) {
        PerformancePiece_Player pppToAdd = new PerformancePiece_Player(incomingPPP.getPerformancePiece(), incomingPPP.getInstrumentEnum());
        pppRepo.save(pppToAdd);
        System.out.println(pppToAdd.getPerformancePiece().getPiece().getTitle() + "    " + pppToAdd.getInstrumentEnum());
        return (Collection<PerformancePiece_Player>) pppRepo.findAll();
    }

    @PostMapping("/get-ppps-from-pp")
    public Collection<PerformancePiece_Player> getAllPPPsFromPerformancePiece(@RequestBody PerformancePiece incomingPP) {
        Collection<PerformancePiece_Player> pppsToReturn = new ArrayList<>();
        if(performancePieceRepo.findById(incomingPP.getId()).isPresent()) {
            pppsToReturn.addAll(pppRepo.findAllByPerformancePiece(incomingPP));
        }
        return pppsToReturn;
    }

    @PostMapping("/get-chairs-in-pp")
    public Collection<PInChair> getAllChairsInPiece(@RequestBody PerformancePiece incomingPP) {
        Optional<PerformancePiece> ppToFind = performancePieceRepo.findById(incomingPP.getId());
        return ppToFind.map(PerformancePiece::getChairsToFill).orElse(null);
    }


}
