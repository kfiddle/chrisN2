package com.example.demo;

import com.example.demo.junctionTables.InstrumentPlayer;
import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.models.Instrument;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.models.Player;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    InstrumentRepository instrumentRepo;

    @Resource
    PerformanceRepository performanceRepo;

    @Resource
    InstrumentPlayerRepository instrumentPlayerRepo;

    @Resource
    PieceRepository pieceRepo;

    @Resource
    PerformancePieceRepository performancePieceRepo;

    @Resource
    PerformancePiece_PlayerRepository pppRepo;


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

        Piece wagnerOverture = new Piece("Lohengrin", "Wagner");
        Piece pulcinella = new Piece("Pulcinella", "Stravinsky");
        Piece mahler = new Piece("Symphony 2", "Mahler");
        Piece fidelio = new Piece("Fidelio", "Beethoven");

        pieceRepo.saveAll(Arrays.asList(wagnerOverture, pulcinella, mahler, fidelio));

        Performance messiah = new Performance("Messiah", LocalDate.of(2021, 12, 10));
        Performance sym1 = new Performance("Sym 1", LocalDate.of(2022, 1, 9));
        Performance pops1 = new Performance("Pops 1", LocalDate.of(2021, 12, 11));
        performanceRepo.saveAll(Arrays.asList(messiah, pops1, sym1));


        PerformancePiece first = new PerformancePiece(messiah, wagnerOverture, 1);
        PerformancePiece second = new PerformancePiece(pops1, wagnerOverture, 3);
        PerformancePiece pulcAtSym1 = new PerformancePiece(sym1, pulcinella, 2);
        PerformancePiece mahlerAtSym1 = new PerformancePiece(sym1, mahler, 3);
        PerformancePiece fidelioAtSym1 = new PerformancePiece(sym1, fidelio, 1);

        performancePieceRepo.saveAll(Arrays.asList(first, second, pulcAtSym1, mahlerAtSym1, fidelioAtSym1));

        PerformancePiece_Player clarinet1 = new PerformancePiece_Player(first, ami);
        PerformancePiece_Player bassClarinet = new PerformancePiece_Player(second, ami);

        pppRepo.saveAll(Arrays.asList(clarinet1, bassClarinet));


    }
}
