package com.example.demo.controllers;


import com.example.demo.enums.Type;
import com.example.demo.junctionTables.InstrumentPlayer;
import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.junctionTables.PlayerPerformanceReply;
import com.example.demo.models.Instrument;
import com.example.demo.models.Performance;
import com.example.demo.models.Player;
import com.example.demo.repositories.*;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

import static com.example.demo.enums.Type.CONTRACT;
import static com.example.demo.enums.Type.SUB;

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

    @RequestMapping("/get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {
        return playerRepo.findByType(CONTRACT, Sort.by("subRanking", "lastName"));
    }

    @RequestMapping("/get-all-sub-players")
    public Collection<Player> getAllSubPlayers() {
        return playerRepo.findByType(SUB, Sort.by("subRanking", "lastName"));
    }

    @PostMapping("/add-player")
    public Player addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

            } else {
                Player playerToAdd = new Player(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
                playerToAdd.setAllProps(incomingPlayer);
                System.out.println(playerToAdd.getFirstNameArea() + "  " + playerToAdd.getLastName() + playerToAdd.getCellPhone());
                playerRepo.save(playerToAdd);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

    }

    @PostMapping("/add-instruments")
    public void addPlayerInstrumentsToDatabase(@RequestBody InstrumentPlayer ip) {
        if (playerRepo.findById(ip.getPlayer().getId()).isPresent()) {
            InstrumentPlayer newIpToSubmit = new InstrumentPlayer(ip.getInstrument(), ip.getPlayer(), ip.getRank());
            instrumentPlayerRepo.save(newIpToSubmit);
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

    @PostMapping("/players/{type}")
    public Collection<Player> getPlayersOfCertainInstrument(@PathVariable Type type, @RequestBody Instrument instrument) {
        Collection<Player> playersToReturn = new ArrayList<>();
        for (InstrumentPlayer ip : instrumentPlayerRepo.findAll()) {
            if (ip.getInstrument().getId().equals(instrument.getId()) && ip.getPlayer().getType() == type) {
                playersToReturn.add(ip.getPlayer());
            }
        }
        return playersToReturn;
    }


    @PostMapping("/add-reply")
    public Collection<PlayerPerformanceReply> addReplyToDatabase(@RequestBody PlayerPerformanceReply incomingReply) {

        try {
            if (replyRepo.existsByPlayerAndPerformance(incomingReply.getPlayer(), incomingReply.getPerformance())) {
                replyRepo.deleteById(replyRepo.findByPlayerAndPerformance(incomingReply.getPlayer(), incomingReply.getPerformance()).getId());

                for (PerformancePiece piece : ppRepo.findAllByPerformance(incomingReply.getPerformance())) {
                    if (pppRepo.existsByPerformancePieceAndPlayer(piece, incomingReply.getPlayer())) {
                        Collection<PerformancePiece_Player> pppsToRemovePlayer = pppRepo.findAllByPerformancePieceAndPlayer(piece, incomingReply.getPlayer());

                        for (PerformancePiece_Player pppToDelete : pppsToRemovePlayer) {
                            pppToDelete.setPlayer(null);
                        }
                    }
                }
            }

            PlayerPerformanceReply replyToAdd = new PlayerPerformanceReply(incomingReply.getPlayer(), incomingReply.getPerformance(), incomingReply.isAvailable());
            replyRepo.save(replyToAdd);

            for (PerformancePiece piece : ppRepo.findAllByPerformance(replyToAdd.getPerformance())) {

                if (!pppRepo.existsByPerformancePieceAndPlayer(piece, replyToAdd.getPlayer())) {
                    for (PerformancePiece_Player ppp : pppRepo.findAllByPerformancePiece(piece)) {
                        if (ppp.getPlayer() == null && replyToAdd.getPlayer().getContractInstrumentEnum() == ppp.getInstrumentEnum()) {
                            ppp.setPlayer(replyToAdd.getPlayer());
                            pppRepo.save(ppp);
                            break;
                        }
                    }
                }
            }

        } catch (
                Exception error) {
            error.printStackTrace();
        }


        return (Collection<PlayerPerformanceReply>) replyRepo.findAll();


    }


}
