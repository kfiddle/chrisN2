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

            }

            PlayerPerformanceReply replyToAdd = new PlayerPerformanceReply(incomingReply.getPlayer(), incomingReply.getPerformance(), incomingReply.isAvailable());
            replyRepo.save(replyToAdd);

            Collection<PlayerPerformanceReply> availableReplies = new ArrayList<>(replyRepo.findAllByPerformanceAndAvailable(replyToAdd.getPerformance(), true));

            Collection<PerformancePiece_Player> pppsToSetPlayers = new ArrayList<>();

            for (PerformancePiece pp : ppRepo.findAllByPerformance(replyToAdd.getPerformance())) {
                pppsToSetPlayers.addAll(pppRepo.findAllByPerformancePiece(pp));
            }

            for (PerformancePiece_Player ppp : pppsToSetPlayers) {
                for (PlayerPerformanceReply reply : availableReplies) {
                    if (reply.getPlayer().getContractInstrumentEnum() == ppp.getInstrumentEnum()) {
                        ppp.setPlayer(reply.getPlayer());
                        availableReplies.remove(reply);
                        break;
                    }
                }
            }
            pppRepo.saveAll(pppsToSetPlayers);
            for (PerformancePiece_Player ppp : pppsToSetPlayers) {
                if (ppp.getPlayer() != null) {
                    System.out.println("This is it with ...   " + ppp.getPlayer().getFirstNameArea() + "     " + ppp.getInstrumentEnum());

                }
            }


        } catch (Exception error) {
            error.printStackTrace();
        }


        return (Collection<PlayerPerformanceReply>) replyRepo.findAll();


    }


}
