package com.example.demo.controllers;

import com.example.demo.models.Contract;
import com.example.demo.models.Player;
import com.example.demo.repositories.ContractRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin
@RestController

public class ContractRest {

    @Resource
    ContractRepository contractRepo;

    @Resource
    PlayerRepository playerRepo;


    @PostMapping("/add-contract")
    public Player addContractToPlayerInDatabase(@RequestBody Player incomingPlayer, @RequestBody Contract incomingContract) throws IOException {

        try {
            if (playerRepo.findById(incomingPlayer.getId()).isPresent()) {
                Player playerToGetContract = playerRepo.findById(incomingPlayer.getId()).get();
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
        } return null;
    }
}
