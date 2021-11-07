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


        String[] instruments = {"Piccolo", "Flute", "Alto Flute", "Oboe", "English Horn", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Sax",
                "Bassoon", "Contra", "Horn", "Trumpet", "Trombone", "Bass Trombone", "Euphonium", "Tuba", "Timpani", "Percussion",
                "Harp", "Piano", "Keyboard", "Violin 1", "Violin 2", "Viola", "Cello", "Bass"};

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
        Player benC = new Player("Benjamin", "Chen", EnumMainType.CONTRACT, InstrumentEnum.CLARINET);


        Player jenJ = new Player("Jennifer", "Jansen", EnumMainType.CONTRACT, InstrumentEnum.VIOLIN2);
        Player jeffS = new Player("Jeff", "Singler", EnumMainType.CONTRACT, InstrumentEnum.CELLO);
        Player jiYoung = new Player("Ji Young", "Nam", EnumMainType.CONTRACT, InstrumentEnum.VIOLA);

        Player db = new Player("David", "Boutin-Bourque", EnumMainType.CONTRACT, InstrumentEnum.HORN);
        Player kdo = new Player("KeriAnn", "DiBari-Oberle", EnumMainType.CONTRACT, InstrumentEnum.EBCLARINET);

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

        Player jm = new Player("Jonathan", "Moser", EnumMainType.CONTRACT);
        Player tobias = new Player("Tobias", "Chisnall", EnumMainType.CONTRACT);
        Player jiyeonY = new Player("Jiyeon", "Yeo", EnumMainType.CONTRACT);
        Player cv = new Player("Colleen", "Vanderzyden", EnumMainType.CONTRACT);
        Player kf = new Player("Karen", "Ferren", EnumMainType.CONTRACT);
        Player hl = new Player("Howard", "Lyon", EnumMainType.CONTRACT);
        Player ln = new Player("Louis", "Nicolia", EnumMainType.CONTRACT);
        Player ee = new Player("Emilie", "Engel", EnumMainType.CONTRACT);
        Player sy = new Player("Si", "Yu", EnumMainType.CONTRACT);

        Player eriS = new Player("Eri", "Snowden-Rodriguez", EnumMainType.CONTRACT, InstrumentEnum.CELLO);
        Player wt = new Player("Will", "Teegarden", EnumMainType.CONTRACT);
        Player nadineS = new Player("Nadine", "Sherman", EnumMainType.CONTRACT);
        Player bn = new Player("Robert ", "Nicholson", EnumMainType.CONTRACT);
        Player jv = new Player("Jean ", "Verdecchia", EnumMainType.CONTRACT);

        Player kieranH = new Player("Kieran", "Hanlon", EnumMainType.CONTRACT);
        Player josephH = new Player("Joseph", "Hernandez", EnumMainType.CONTRACT);
        Player tomC = new Player("Thomas", "Christopherson", EnumMainType.CONTRACT);
        Player jamesM = new Player("James", "Mohney", EnumMainType.CONTRACT);

        Player mariaV = new Player("Maria", "Park", EnumMainType.SUB);
        Player beano = new Player("Mike", "Chen", EnumMainType.SUB);
        Player dianaV = new Player("Diana", "Pepelea", EnumMainType.SUB);


        playerRepo.saveAll(Arrays.asList(leAnne, seanG, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaV, beano, dianaV));


        instrumentPlayerRepo.saveAll(Arrays.asList(new InstrumentPlayer(instrumentRepo.findByName("Flute"), leAnne, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Flute"), seanG, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Oboe"), danna, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Oboe"), heatherS, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Oboe"), sarahH, 3),
                new InstrumentPlayer(instrumentRepo.findByName("English Horn"), sarahH, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), ami, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), benC, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), db, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Bass Clarinet"), db, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Clarinet"), kdo, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Eb Clarinet"), kdo, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Bassoon"), lk, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Bassoon"), lel, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Horn"), cr, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Horn"), ma, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Horn"), es, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Horn"), ba, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Horn"), bs, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Trumpet"), gd, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Trumpet"), da, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Trumpet"), mh, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Trombone"), wc, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Bass Trombone"), sb, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Tuba"), kh, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Percussion"), bradA, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Percussion"), ml, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Harp"), mr, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), kj, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), sls, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), jh, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), melissaH, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), ah, 5),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), stefS, 6),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), yk, 7),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), mp, 8),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 1"), jc, 9),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), jm, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), jenJ, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), tobias, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), jiyeonY, 5),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), cv, 6),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), kf, 7),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), hl, 8),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), ln, 9),
                new InstrumentPlayer(instrumentRepo.findByName("Violin 2"), ee, 10),
                new InstrumentPlayer(instrumentRepo.findByName("Viola"), jiYoung, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Viola"), sy, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Viola"), benS, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), eriS, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), wt, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), nadineS, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), jeffS, 4),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), bn, 5),
                new InstrumentPlayer(instrumentRepo.findByName("Cello"), jv, 6),
                new InstrumentPlayer(instrumentRepo.findByName("Bass"), kh, 1),
                new InstrumentPlayer(instrumentRepo.findByName("Bass"), josephH, 2),
                new InstrumentPlayer(instrumentRepo.findByName("Bass"), tomC, 3),
                new InstrumentPlayer(instrumentRepo.findByName("Bass"), jamesM, 4)));


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


    }
}
