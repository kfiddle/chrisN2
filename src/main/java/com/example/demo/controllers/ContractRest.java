package com.example.demo.controllers;

import com.example.demo.models.Contract;
import com.example.demo.models.Player;
import com.example.demo.repositories.ContractRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

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
                System.out.println(contractToAdd.getPart() + "  " + contractToAdd.getRank());
                return playerToGetContract;

            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}
