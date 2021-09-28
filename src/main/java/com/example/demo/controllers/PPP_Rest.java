package com.example.demo.controllers;


import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.repositories.PerformancePiece_PlayerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class PPP_Rest {

    @Resource
    PerformancePiece_PlayerRepository pppRepo;


//    @PostMapping("/add-ppp")
//    public Collection<PerformancePiece_Player> addPPPToDatabase(@RequestBody PerformancePiece_Player incomingPPP) {
//
//    }


}
