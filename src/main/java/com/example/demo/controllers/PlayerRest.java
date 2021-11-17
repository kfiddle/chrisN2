package com.example.demo.controllers;


import com.example.demo.enums.Part;
import com.example.demo.junctionTables.InstrumentPlayer;
import com.example.demo.models.Contract;
import com.example.demo.models.Instrument;
import com.example.demo.models.Player;
import com.example.demo.repositories.*;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;


@CrossOrigin
@RestController
public class PlayerRest {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    InstrumentPlayerRepository instrumentPlayerRepo;

    @Resource
    PlayerPerformanceReplyRepository replyRepo;

    @Resource
    PerformancePieceRepository ppRepo;

    @Resource
    PerformancePiece_PlayerRepository pppRepo;

    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {


        return (Collection<Player>) playerRepo.findAll();
    }

//    @RequestMapping("get-contract-players-by-part/{part}")
//    public Collection<Player> getPlayersByPrimaryPart(@PathVariable String part) {
//        Collection<Player> playersToSend = new ArrayList<>();
//        Collection<Player> playersToSort = playerRepo.findByContractedAndPrimaryPart(true, Part.valueOf(part));
//
//        for (int j = 1; j <= playersToSort.size(); j++) {
//            for (Player player : playersToSort) {
//                if (player.getContract().getRank() == j) {
//                    playersToSend.add(player);
//                }
//            }
//        }
//        return playersToSend;
//
//        System.out.println(Part.valueOf(part));
//        return playersToSort;
//    }

    @RequestMapping("/get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {

        return playerRepo.findAllByHasContract(true);
    }

    @RequestMapping("/get-all-sub-players")
    public Collection<Player> getAllSubPlayers() {
        return playerRepo.findAllByHasContract(false);
    }

    @RequestMapping("/get-all-contracts")
    public Collection<Player> playersWithContracts() {

        List<Player> playersToSendBack = (List<Player>) playerRepo.findAllByHasContract(true);
        Collections.sort(playersToSendBack);

        return playersToSendBack;
    }


    @PostMapping("/add-player")
    public Player addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

            } else {
                Player playerToAdd = new Player(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
                playerToAdd.setAllProps(incomingPlayer);

//                System.out.println(playerToAdd.getFirstNameArea() + "  " + "Contracted:  " + playerToAdd.hasContract());
//                System.out.println(playerToAdd.getFirstNameArea() + "  " + playerToAdd.getLastName() + playerToAdd.getCellPhone());

                if (playerToAdd.getParts() != null) {
                    for (Part part : playerToAdd.getParts()) {
                        System.out.println(part.toString());
                    }
                }

                playerRepo.save(playerToAdd);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

    }

    @PostMapping("/add-instruments")
    public void addPlayerInstrumentsToDatabase(@RequestBody InstrumentPlayer ip) throws IOException {
        try {
            if (playerRepo.findById(ip.getPlayer().getId()).isPresent()) {
                InstrumentPlayer newIpToSubmit = new InstrumentPlayer(ip.getInstrument(), ip.getPlayer(), ip.getRank());
                instrumentPlayerRepo.save(newIpToSubmit);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    @PostMapping("/edit-player")
    public Collection<Player> editPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.findById(incomingPlayer.getId()).isEmpty()) {
                return (Collection<Player>) playerRepo.findAll();
            } else {
                Player playerToEdit = playerRepo.findById(incomingPlayer.getId()).get();
                playerToEdit.setAllProps(incomingPlayer);
                playerRepo.save(playerToEdit);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return (Collection<Player>) playerRepo.findAll();
    }

    @PostMapping("/players/{contracted}")
    public Collection<Player> getPlayersOfCertainInstrument(@PathVariable boolean contracted, @RequestBody Instrument instrument) {
        Collection<Player> playersToReturn = new ArrayList<>();
        for (InstrumentPlayer ip : instrumentPlayerRepo.findAll()) {
            if (ip.getInstrument().getId().equals(instrument.getId()) && ip.getPlayer().hasContract() == contracted) {
                playersToReturn.add(ip.getPlayer());
            }
        }
        return playersToReturn;
    }


//    @PostMapping("/add-reply")
//    public Collection<PlayerPerformanceReply> addReplyToDatabase(@RequestBody PlayerPerformanceReply incomingReply) {
//
//        try {
//            if (replyRepo.existsByPlayerAndPerformance(incomingReply.getPlayer(), incomingReply.getPerformance())) {
//                replyRepo.deleteById(replyRepo.findByPlayerAndPerformance(incomingReply.getPlayer(), incomingReply.getPerformance()).getId());
//
//                for (PerformancePiece piece : ppRepo.findAllByPerformance(incomingReply.getPerformance())) {
//                    if (pppRepo.existsByPerformancePieceAndPlayer(piece, incomingReply.getPlayer())) {
//                        Collection<PerformancePiece_Player> pppsToRemovePlayer = pppRepo.findAllByPerformancePieceAndPlayer(piece, incomingReply.getPlayer());
//
//                        for (PerformancePiece_Player pppToDelete : pppsToRemovePlayer) {
//                            pppToDelete.setPlayer(null);
//                        }
//                    }
//                }
//            }
//
//            PlayerPerformanceReply replyToAdd = new PlayerPerformanceReply(incomingReply.getPlayer(), incomingReply.getPerformance(), incomingReply.isAvailable());
//            replyRepo.save(replyToAdd);
//
//            for (PerformancePiece piece : ppRepo.findAllByPerformance(replyToAdd.getPerformance())) {
//
//                if (!pppRepo.existsByPerformancePieceAndPlayer(piece, replyToAdd.getPlayer())) {
//                    for (PerformancePiece_Player ppp : pppRepo.findAllByPerformancePiece(piece)) {
//                        if (ppp.getPlayer() == null && replyToAdd.getPlayer().getContractInstrumentEnum() == ppp.getInstrumentEnum()) {
//                            ppp.setPlayer(replyToAdd.getPlayer());
//                            pppRepo.save(ppp);
//                            break;
//                        }
//                    }
//                }
//            }
//
//        } catch (
//                Exception error) {
//            error.printStackTrace();
//        }
//
//
//        return (Collection<PlayerPerformanceReply>) replyRepo.findAll();
//
//
//    }


}
