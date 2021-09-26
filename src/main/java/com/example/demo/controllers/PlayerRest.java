package com.example.demo.controllers;


import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

import static com.example.demo.enums.Type.CONTRACT;
import static com.example.demo.enums.Type.SUB;

@CrossOrigin
@RestController
public class PlayerRest {

    @Resource
    PlayerRepository playerRepo;


    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {
        return (Collection<Player>) playerRepo.findAll();
    }

    @RequestMapping("/get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {
        return playerRepo.findByType(CONTRACT, Sort.by("subRanking", "lastName"));
    }

    @RequestMapping("/get-all-sub-players")
    public Collection<Player> getAllSubPlayers() {
        return playerRepo.findByType(SUB, Sort.by("subRanking", "lastName"));
    }

}
