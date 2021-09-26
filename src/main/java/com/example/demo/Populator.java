package com.example.demo;

import com.example.demo.junctionTables.InstrumentPlayer;
import com.example.demo.models.Instrument;
import com.example.demo.models.Player;
import com.example.demo.repositories.InstrumentPlayerRepository;
import com.example.demo.repositories.InstrumentRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;
import java.util.Arrays;

public class Populator implements CommandLineRunner {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    InstrumentRepository instrumentRepo;

    @Resource
    InstrumentPlayerRepository instrumentPlayerRepo;

    @Override
    public void run(String... args) throws Exception {

        String[] instruments = {"Violin", "Viola", "Cello", "Bass", "Flute", "Oboe", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Bassoon",
                "Horn", "Trumpet", "Trombone", "Tuba", "Timpani", "Percussion", "Harp", "Keyboard", "Piano"};

        for (String instrument : instruments) {
            instrumentRepo.save(new Instrument(instrument));
        }

        Player ami = new Player("Ami", "Vardi");
        playerRepo.save(ami);

        InstrumentPlayer firstClarinet = new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), ami, 1);
        InstrumentPlayer secondIsBass = new InstrumentPlayer(instrumentRepo.findByName(" Bass Clarinet"), ami, 2);

        instrumentPlayerRepo.saveAll(Arrays.asList(firstClarinet, secondIsBass));


    }
}
