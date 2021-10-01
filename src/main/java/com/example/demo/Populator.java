package com.example.demo;

import com.example.demo.enums.InstrumentEnum;
import com.example.demo.enums.Type;
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
        Player liesl = new Player("Liesl", "Hook");
        playerRepo.saveAll(Arrays.asList(ami, liesl));
        ami.setType(Type.CONTRACT);
        liesl.setType(Type.SUB);
        playerRepo.saveAll(Arrays.asList(ami, liesl));


        Player leAnne = new Player("Leanne", "Wistrom", Type.CONTRACT, InstrumentEnum.FLUTE);
        Player seanG = new Player("Sean", "Gabriel", Type.CONTRACT);
        Player sarahH = new Player("Sarah", "Hamilton", Type.CONTRACT);
        Player danna = new Player("Danna", "Sundet", Type.CONTRACT);
        Player heatherS = new Player("Heather", "Storey", Type.CONTRACT);
        Player jenJ = new Player("Jennifer", "Jansen", Type.CONTRACT);
        Player jeffS = new Player("Jeff", "Singler", Type.CONTRACT);
        Player jiYoung = new Player("Ji Young", "Nam", Type.CONTRACT, InstrumentEnum.VIOLA);

        Player db = new Player("David", "Boutin-Bourque", Type.CONTRACT);
        Player lk = new Player("Laura", "Laura Koepke", Type.CONTRACT);
        Player lel = new Player("Sarah Elizabeth", "Lee", Type.CONTRACT);
        Player cr = new Player("Chris", "Rapier", Type.CONTRACT);
        Player ma = new Player("Mark", "Addleman", Type.CONTRACT);
        Player es = new Player("Emily", "Shelley", Type.CONTRACT);
        Player ba = new Player("Bryan", "Adkins", Type.CONTRACT);
        Player bs = new Player("Benjamin", "Strecker", Type.CONTRACT);
        Player gd = new Player("Gary", "Davis", Type.CONTRACT);
        Player da = new Player("Douglas", "Amos", Type.CONTRACT);
        Player mh = new Player("Micah", "Holt", Type.CONTRACT);
        Player wc = new Player("Whitney", "Claire", Type.CONTRACT);
        Player sb = new Player("Sean", "Bessette", Type.CONTRACT);
        Player kh = new Player("Ken", "Heinlein", Type.CONTRACT);
        Player bradA = new Player("Brad", "Amidon", Type.CONTRACT);
        Player ml = new Player("Matt", "Larson", Type.CONTRACT);
        Player mr = new Player("Melody", "Rapier", Type.CONTRACT);


        Player kj = new Player("Ken", "Johnston", Type.CONTRACT, InstrumentEnum.VIOLIN1);
        Player sls = new Player("Sandro", "Leal-Santiesteban", Type.CONTRACT, InstrumentEnum.VIOLIN1);
        Player jh = new Player("Joshua", "Huang", Type.CONTRACT, InstrumentEnum.VIOLIN1);
        Player melissaH = new Player("Melissa", "Hernandez", Type.CONTRACT);
        Player ah = new Player("Alexander", "Hettinga", Type.CONTRACT);
        Player stefS = new Player("Stefanie", "Schore", Type.CONTRACT);
        Player yk = new Player("Yejee", "Kim", Type.CONTRACT);
        Player mp = new Player("Maura", "Pelinsky", Type.CONTRACT);
        Player jc = new Player("Janice", "Carlson", Type.CONTRACT);
        Player benS = new Player("Benjamin", "Schantz", Type.CONTRACT);


        Player ericaS = new Player("Erica", "Snowden-Rodriguez", Type.CONTRACT, InstrumentEnum.CELLO);
        Player wt = new Player("Will", "Teegarden", Type.CONTRACT);
        Player nadineS = new Player("Nadine", "Sherman", Type.CONTRACT);
        Player bt = new Player("Robert ", "Nicholson", Type.CONTRACT);
        Player jv = new Player("Jean ", "Verdecchia", Type.CONTRACT);

        Player kieranH = new Player("Kieran", "Hanlon", Type.CONTRACT);
        Player josephH = new Player("Joseph", "Hernandez", Type.CONTRACT);
        Player tomC = new Player("Thomas", "Christopherson", Type.CONTRACT);
        Player jamesM = new Player("James", "Mohney", Type.CONTRACT);

        Player mariaV = new Player("Maria", "Park", Type.SUB);
        Player gingerV = new Player("Ginger", "Smith", Type.SUB);
        Player beano = new Player("Mike", "Chen",  Type.SUB);
        Player gracie = new Player("Lou", "Lev",  Type.SUB);
        Player doodle = new Player("Susan", "Britton",  Type.SUB);
        Player nHess = new Player("Diana", "Pepelea",  Type.SUB);

        playerRepo.saveAll(Arrays.asList(leAnne, seanG, sarahH, danna, heatherS, jenJ, jeffS, jiYoung, db, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, benS,
                ericaS, wt, nadineS, bt, jv, kieranH, josephH, tomC, jamesM, mariaV, gingerV, beano, gracie, doodle, nHess));


        InstrumentPlayer firstClarinet = new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), ami, 1);
        InstrumentPlayer secondIsBass = new InstrumentPlayer(instrumentRepo.findByName("Bass Clarinet"), ami, 2);
        InstrumentPlayer lieslViolin = new InstrumentPlayer(instrumentRepo.findByName("Violin"), liesl, 1);
        InstrumentPlayer lef = new InstrumentPlayer(instrumentRepo.findByName("Flute"), leAnne, 1);
        InstrumentPlayer seanFl = new InstrumentPlayer(instrumentRepo.findByName("Flute"), seanG, 1);
        InstrumentPlayer saraB = new InstrumentPlayer(instrumentRepo.findByName("Oboe"), sarahH, 1);
        InstrumentPlayer dannaO = new InstrumentPlayer(instrumentRepo.findByName("Oboe"), danna, 1);
        InstrumentPlayer heatherO = new InstrumentPlayer(instrumentRepo.findByName("Oboe"), heatherS, 1);
        InstrumentPlayer jenV = new InstrumentPlayer(instrumentRepo.findByName("Jen"), jenJ, 1);
        InstrumentPlayer jeffC = new InstrumentPlayer(instrumentRepo.findByName("Cello"), jeffS, 1);
        InstrumentPlayer bradP = new InstrumentPlayer(instrumentRepo.findByName("Percussion"), bradA, 1);
        InstrumentPlayer bradPT = new InstrumentPlayer(instrumentRepo.findByName("Timpani"), bradA, 2);
        InstrumentPlayer jamesMB = new InstrumentPlayer(instrumentRepo.findByName("Bass"), jamesM, 1);

        InstrumentPlayer mariaVV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), mariaV, 1);
        InstrumentPlayer gingerVV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), gingerV, 1);
        InstrumentPlayer mikeChenV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), beano, 1);
        InstrumentPlayer louV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), gracie, 1);
        InstrumentPlayer susanV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), doodle, 1);
        InstrumentPlayer dianaV = new InstrumentPlayer(instrumentRepo.findByName("Violin"), nHess, 1);



        instrumentPlayerRepo.saveAll(Arrays.asList(firstClarinet, secondIsBass, lieslViolin, lef, seanFl, saraB, dannaO,
                heatherO, jeffC, bradPT, jamesMB, mariaVV, gingerVV, mikeChenV, louV, susanV, dianaV ));

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

//        PerformancePiece_Player clarinet1 = new PerformancePiece_Player(first, ami);
//        PerformancePiece_Player bassClarinet = new PerformancePiece_Player(second, ami);

//        pppRepo.saveAll(Arrays.asList(clarinet1, bassClarinet));


    }
}
