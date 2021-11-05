package com.example.demo;

import com.example.demo.enums.InstrumentEnum;
import com.example.demo.enums.EnumMainType;
import com.example.demo.junctionTables.InstrumentPlayer;
import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


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

//        String[] instruments = {"Violin", "Viola", "Cello", "Bass", "Flute", "Oboe", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Bassoon",
//                "Horn", "Trumpet", "Trombone", "Tuba", "Timpani", "Percussion", "Harp", "Keyboard", "Piano"};


        String[] instruments = {"Piccolo","Flute", "Alto Flute", "Oboe", "English Horn", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Sax",
                "Bassoon", "Contra", "Horn", "Trumpet", "Trombone", "Bass Trombone","Euphonium", "Tuba", "Timpani", "Percussion",
                "Harp", "Piano", "Keyboard","Violin", "Viola", "Cello", "Bass"};


        for (String instrument : instruments) {
            instrumentRepo.save(new Instrument(instrument));
        }

        Player ami = new Player("Ami", "Vardi");
        Player liesl = new Player("Liesl", "Hook");
        playerRepo.saveAll(Arrays.asList(ami, liesl));
        ami.setPrimaryType(EnumMainType.CONTRACT);
        liesl.setPrimaryType(EnumMainType.SUB);
        playerRepo.saveAll(Arrays.asList(ami, liesl));


        Player leAnne = new Player("Leanne", "Wistrom", EnumMainType.CONTRACT, InstrumentEnum.FLUTE);
        Player seanG = new Player("Sean", "Gabriel", EnumMainType.CONTRACT, InstrumentEnum.FLUTE);
        Player sarahH = new Player("Sarah", "Hamilton", EnumMainType.CONTRACT, InstrumentEnum.OBOE);
        Player danna = new Player("Danna", "Sundet", EnumMainType.CONTRACT, InstrumentEnum.OBOE);
        Player heatherS = new Player("Heather", "Storey", EnumMainType.CONTRACT, InstrumentEnum.OBOE);
        Player jenJ = new Player("Jennifer", "Jansen", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN2);
        Player jeffS = new Player("Jeff", "Singler", EnumMainType.CONTRACT, InstrumentEnum.CELLO);
        Player jiYoung = new Player("Ji Young", "Nam", EnumMainType.CONTRACT, InstrumentEnum.VIOLA);

        Player db = new Player("David", "Boutin-Bourque", EnumMainType.CONTRACT, InstrumentEnum.HORN);
        Player lk = new Player("Laura", "Laura Koepke", EnumMainType.CONTRACT, InstrumentEnum.BASSOON);
        Player lel = new Player("Sarah Elizabeth", "Lee", EnumMainType.CONTRACT, InstrumentEnum.BASSOON);
        Player cr = new Player("Chris", "Rapier", EnumMainType.CONTRACT, InstrumentEnum.HORN);
        Player ma = new Player("Mark", "Addleman", EnumMainType.CONTRACT);
        Player es = new Player("Emily", "Shelley", EnumMainType.CONTRACT, InstrumentEnum.HORN);
        Player ba = new Player("Bryan", "Adkins", EnumMainType.CONTRACT, InstrumentEnum.HORN);
        Player bs = new Player("Benjamin", "Strecker", EnumMainType.CONTRACT);
        Player gd = new Player("Gary", "Davis", EnumMainType.CONTRACT, InstrumentEnum.TRUMPET);
        Player da = new Player("Douglas", "Amos", EnumMainType.CONTRACT);
        Player mh = new Player("Micah", "Holt", EnumMainType.CONTRACT, InstrumentEnum.TRUMPET);
        Player wc = new Player("Whitney", "Claire", EnumMainType.CONTRACT, InstrumentEnum.TROMBONE);
        Player sb = new Player("Sean", "Bessette", EnumMainType.CONTRACT);
        Player kh = new Player("Ken", "Heinlein", EnumMainType.CONTRACT, InstrumentEnum.TUBA);
        Player bradA = new Player("Brad", "Amidon", EnumMainType.CONTRACT, InstrumentEnum.PERCUSSION);
        Player ml = new Player("Matt", "Larson", EnumMainType.CONTRACT, InstrumentEnum.PERCUSSION);
        Player mr = new Player("Melody", "Rapier", EnumMainType.CONTRACT, InstrumentEnum.HARP);


        Player kj = new Player("Ken", "Johnston", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN1);
        Player sls = new Player("Sandro", "Leal-Santiesteban", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN1);
        Player jh = new Player("Joshua", "Huang", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN1);
        Player melissaH = new Player("Melissa", "Hernandez", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN1);
        Player ah = new Player("Alexander", "Hettinga", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN2);
        Player stefS = new Player("Stefanie", "Schore", EnumMainType.CONTRACT);
        Player yk = new Player("Yejee", "Kim", EnumMainType.CONTRACT);
        Player mp = new Player("Maura", "Pelinsky", EnumMainType.CONTRACT);
        Player jc = new Player("Janice", "Carlson", EnumMainType.CONTRACT);
        Player benS = new Player("Benjamin", "Schantz", EnumMainType.CONTRACT);


        Player ericaS = new Player("Erica", "Snowden-Rodriguez", EnumMainType.CONTRACT, InstrumentEnum.CELLO);
        Player wt = new Player("Will", "Teegarden", EnumMainType.CONTRACT);
        Player nadineS = new Player("Nadine", "Sherman", EnumMainType.CONTRACT);
        Player bt = new Player("Robert ", "Nicholson", EnumMainType.CONTRACT);
        Player jv = new Player("Jean ", "Verdecchia", EnumMainType.CONTRACT);

        Player kieranH = new Player("Kieran", "Hanlon", EnumMainType.CONTRACT);
        Player josephH = new Player("Joseph", "Hernandez", EnumMainType.CONTRACT);
        Player tomC = new Player("Thomas", "Christopherson", EnumMainType.CONTRACT);
        Player jamesM = new Player("James", "Mohney", EnumMainType.CONTRACT);

        Player mariaV = new Player("Maria", "Park", EnumMainType.SUB);
        Player gingerV = new Player("Ginger", "Smith", EnumMainType.SUB);
        Player beano = new Player("Mike", "Chen", EnumMainType.SUB);
        Player gracie = new Player("Lou", "Lev", EnumMainType.SUB);
        Player doodle = new Player("Susan", "Britton", EnumMainType.SUB);
        Player nHess = new Player("Diana", "Pepelea", EnumMainType.SUB);

        Player barnie = new Player("Barney", "Fife", EnumMainType.CONTRACT);


        playerRepo.saveAll(Arrays.asList(leAnne, seanG, sarahH, danna, heatherS, jenJ, jeffS, jiYoung, db, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, benS,
                ericaS, wt, nadineS, bt, jv, kieranH, josephH, tomC, jamesM, mariaV, gingerV, beano, gracie, doodle, nHess, barnie));


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
                heatherO, jeffC, bradPT, jamesMB, mariaVV, gingerVV, mikeChenV, louV, susanV, dianaV));


        pieceRepo.saveAll(Arrays.asList(new Piece("Rapture", "Rouse"),
                new Piece("Violin Concerto in D", "Brahms"),
                new Piece("Firebird Suite(1945)", "Stravinsky"),
                new Piece("The Sorcerer’s Apprentice", "Dukas"),
                new Piece("Concerto for Organ and Orchestra", "Poulenc"),
                new Piece("Symphony in D minor", "Franck"),
                new Piece("Along the Western Shore", "Remick-Warren"),
                new Piece("Prelude and Liebestod from Tristan und Isolde", "Wagner"),
                new Piece("Piano Concerto No. 3", "Rachmaninoff"),
                new Piece("Mary Poppins (Full Film)", "Sherman and Sherman"),
                new Piece("Star Wars: A New Hope ", "Williams"),
                new Piece("New Work based on Harriet Tubman", "Timothy Adams"),
                new Piece("Concertino da Camera for Alto Saxophone and Orchestra", "Ibert"),
                new Piece("Concerto, Alto Saxophone, op.109, E-flat major", "Glazunov"),
                new Piece("Symphony No. 7", "Beethoven"),
                new Piece("Rise", "Zhou Tian"),
                new Piece("Symphony No.2", "Mahler")));


        DateTime sym1Date = new DateTime(LocalDate.of(2022, 1, 8), LocalTime.of(8, 0));

        DateTime pops1First = new DateTime(LocalDate.of(2021, 12, 4), LocalTime.of(3, 0));
        DateTime pops1Second = new DateTime(LocalDate.of(2021, 12, 4), LocalTime.of(8, 0));
        DateTime pops2Date = new DateTime(LocalDate.of(2022, 1, 29), LocalTime.of(8, 0));
        DateTime sym2Date = new DateTime(LocalDate.of(2022, 2, 26), LocalTime.of(8, 0));
        DateTime sym3Date = new DateTime(LocalDate.of(2022, 3, 19), LocalTime.of(8, 0));
        DateTime pops3DateFirst = new DateTime(LocalDate.of(2022, 4, 9), LocalTime.of(8, 0));
        DateTime pops3DateSecond = new DateTime(LocalDate.of(2022, 4, 10), LocalTime.of(3, 0));
        DateTime pops4First = new DateTime(LocalDate.of(2022, 4, 30), LocalTime.of(8, 0));
        DateTime pops4Second = new DateTime(LocalDate.of(2022, 5, 1), LocalTime.of(3, 0));
        DateTime sym4Date = new DateTime(LocalDate.of(2022, 5, 14), LocalTime.of(8, 0));
        DateTime pops5Date = new DateTime(LocalDate.of(2022, 6, 12), LocalTime.of(3, 0));
        DateTime sym5Date = new DateTime(LocalDate.of(2022, 6, 26), LocalTime.of(3, 0));

        List<DateTime> pops1Dates = new ArrayList<>();
        pops1Dates.add(pops1First);
        pops1Dates.add(pops1Second);

        List<DateTime> pops3Dates = new ArrayList<>();
        pops3Dates.add(pops3DateFirst);
        pops3Dates.add(pops3DateSecond);

        List<DateTime> pops4Dates = new ArrayList<>();
        pops4Dates.add(pops4First);
        pops4Dates.add(pops4Second);


        Performance pops1 = new Performance("Pops 1: Come Home for the Holidays", pops1Dates);
        Performance sym1 = new Performance("Sym 1: Midori", sym1Date);
        Performance pops2 = new Performance("Pops 2: Music of the Knights", pops2Date);
        Performance sym2 = new Performance("Sym 2: French / Organ", sym2Date);
        Performance sym3 = new Performance("Sym 3: Olga Kern", sym3Date);
        Performance pops3 = new Performance("Pops 3: Mary Poppins in Concert", pops3Dates);
        Performance pops4 = new Performance("Pops 4:Star Wars:A New Hope in Concert", pops4Dates);
        Performance sym4 = new Performance("Sym 4: Tim Adams / saxophone", sym4Date);
        Performance pops5 = new Performance("Pops 5: R&H", pops5Date);
        Performance sym5 = new Performance("Sym 5: Mahler 2", sym5Date);


        performanceRepo.saveAll(Arrays.asList(pops3, pops1, pops2, sym2, sym3, pops4, sym4, pops5, sym5, sym1));


//        PerformancePiece first = new PerformancePiece(wagnerOverture, 1);

//        PerformancePiece pulcAtSym1 = new PerformancePiece(sym1, pulcinella, 2);
//        PerformancePiece mahlerAtSym1 = new PerformancePiece(sym1, mahler, 3);
//        PerformancePiece fidelioAtSym1 = new PerformancePiece(sym1, fidelio, 1);
//
//        performancePieceRepo.saveAll(Arrays.asList(second));


    }
}
