package com.example.demo.controllers;

import com.example.demo.models.Contract;
import com.example.demo.models.Player;
import com.example.demo.repositories.ContractRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController

public class ContractRest {

    @Resource
    ContractRepository contractRepo;

    @Resource
    PlayerRepository playerRepo;


    @PostMapping("/add-contract/{playerId}")
    public Player addContractToPlayerInDatabase(@PathVariable Long playerId, @RequestBody Contract incomingContract) throws IOException {

        try {
            if (playerRepo.findById(playerId).isPresent()) {

                Player playerToGetContract = playerRepo.findById(playerId).get();
                Contract contractToAdd = new Contract();
                contractToAdd.setAllProps(incomingContract);
                contractRepo.save(contractToAdd);
                playerToGetContract.setContract(contractToAdd);
                playerRepo.save(playerToGetContract);
                return playerToGetContract;

            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

//    @RequestMapping("/get-all-contracts")
//    public Collection<Player> playersWithContracts() {
//
//        Collection<Player> playersToSendBack = new ArrayList<>();
//
//        String[] instruments = {"Piccolo", "Flute", "Alto Flute", "Oboe", "English Horn", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Sax",
//                "Bassoon", "Contra", "Horn", "Trumpet", "Trombone", "Bass Trombone", "Euphonium", "Tuba", "Timpani", "Percussion",
//                "Harp", "Piano", "Keyboard", "Violin 1", "Violin 2", "Viola", "Cello", "Bass"};
//
//        for (String instrument : instruments) {
//            for (Contract contract : contractRepo.findAll(Sort.by("rank"))) {
//                if (contract.getPart().toString().equals(instrument)) {
//                    playersToSendBack.add(contract.getPlayer());
//                }
//            }
//        }
//
//        for (Player player : playersToSendBack) {
//            System.out.println(player.getLastName());
//        }
//
//        return playersToSendBack;
//    }
}
