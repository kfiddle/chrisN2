package com.example.demo;

import com.example.demo.enums.Part;
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

    @Resource
    ContractRepository contractRepo;


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
        playerRepo.saveAll(Arrays.asList(ami, liesl));

        Player leAnne = new Player("Leanne", "Wistrom");
        Player seanG = new Player("Sean", "Gabriel");
        Player sarahH = new Player("Sarah", "Hamilton");
        Player danna = new Player("Danna", "Sundet");
        Player heatherS = new Player("Heather", "Storey");
        Player benC = new Player("Benjamin", "Chen");


        Player jenJ = new Player("Jennifer", "Jansen");
        Player jeffS = new Player("Jeff", "Singler");
        Player jiYoung = new Player("Ji Young", "Nam");

        Player db = new Player("David", "Boutin-Bourque");
        Player kdo = new Player("KeriAnn", "DiBari-Oberle");

        Player lk = new Player("Laura", "Laura Koepke");
        Player lel = new Player("Sarah Elizabeth", "Lee");
        Player cr = new Player("Chris", "Rapier");
        Player ma = new Player("Mark", "Addleman");
        Player es = new Player("Emily", "Shelley");
        Player ba = new Player("Bryan", "Adkins");
        Player bs = new Player("Benjamin", "Strecker");
        Player gd = new Player("Gary", "Davis");
        Player da = new Player("Douglas", "Amos");
        Player mh = new Player("Micah", "Holt");
        Player wc = new Player("Whitney", "Claire");
        Player sb = new Player("Sean", "Bessette");
        Player kh = new Player("Ken", "Heinlein");
        Player bradA = new Player("Brad", "Amidon");
        Player ml = new Player("Matt", "Larson");
        Player mr = new Player("Melody", "Rapier");

        Player kj = new Player("Ken", "Johnston");
        Player sls = new Player("Sandro", "Leal-Santiesteban");
        Player jh = new Player("Joshua", "Huang");
        Player melissaH = new Player("Melissa", "Hernandez");
        Player ah = new Player("Alexander", "Hettinga");
        Player stefS = new Player("Stefanie", "Schore");
        Player yk = new Player("Yejee", "Kim");
        Player mp = new Player("Maura", "Pelinsky");
        Player jc = new Player("Janice", "Carlson");
        Player benS = new Player("Benjamin", "Schantz");

        Player jm = new Player("Jonathan", "Moser");
        Player tobias = new Player("Tobias", "Chisnall");
        Player jiyeonY = new Player("Jiyeon", "Yeo");
        Player cv = new Player("Colleen", "Vanderzyden");
        Player kf = new Player("Karen", "Ferren");
        Player hl = new Player("Howard", "Lyon");
        Player ln = new Player("Louis", "Nicolia");
        Player ee = new Player("Emilie", "Engel");
        Player sy = new Player("Si", "Yu");

        Player eriS = new Player("Eri", "Snowden-Rodriguez");
        Player wt = new Player("Will", "Teegarden");
        Player nadineS = new Player("Nadine", "Sherman");
        Player bn = new Player("Robert ", "Nicholson");
        Player jv = new Player("Jean ", "Verdecchia");

        Player kieranH = new Player("Kieran", "Hanlon");
        Player josephH = new Player("Joseph", "Hernandez");
        Player tomC = new Player("Thomas", "Christopherson");
        Player jamesM = new Player("James", "Mohney");

        Player mariaP = new Player("Maria", "Park");
        Player mikeChen = new Player("Mike", "Chen");
        Player dianaV = new Player("Diana", "Pepelea");


        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));

        Contract leAnneCon = new Contract(Part.Flute, 1);
        Contract seanGCon = new Contract(Part.Flute, 2);

        Contract dannaCon = new Contract(Part.Oboe, 1);
        Contract heatherSCon = new Contract(Part.Oboe, 2);
        Contract sarahHCon = new Contract(Part.Oboe, 3, Part.EnglishHorn);

        Contract amiCon = new Contract(Part.Clarinet, 1);
        Contract benChenCon = new Contract(Part.Clarinet, 2);
        Contract dbbCon = new Contract(Part.Clarinet, 3, Part.BassClarinet);
        Contract keriAnnCon = new Contract(Part.Clarinet, 4, Part.EbClarinet);



        Contract cmContract = new Contract(Part.Violin1, 1);
        Contract jjContract = new Contract(Part.Violin2, 3);

        Contract jiYoungContract = new Contract(Part.Viola, 1);
        Contract siYuContract = new Contract(Part.Viola, 3);
        Contract benSchantzContract = new Contract(Part.Viola, 4);

        Contract kieranCon = new Contract(Part.Bass, 1);


        contractRepo.saveAll(Arrays.asList(leAnneCon, seanGCon, amiCon, dbbCon, keriAnnCon, cmContract, jjContract, jiYoungContract, siYuContract, benSchantzContract, kieranCon, dannaCon, sarahHCon, heatherSCon, benChenCon));

        leAnneCon.setPlayer(leAnne);
        seanGCon.setPlayer(seanG);

        dannaCon.setPlayer(danna);
        heatherS.setContract(heatherSCon);
        sarahH.setContract(sarahHCon);

        ami.setContract(amiCon);
        benC.setContract(benChenCon);
        db.setContract(dbbCon);
        kdo.setContract(keriAnnCon);


        cmContract.setPlayer(kj);
        jjContract.setPlayer(jenJ);
        jiYoung.setContract(jiYoungContract);
        sy.setContract(siYuContract);
        benS.setContract(benSchantzContract);
        kieranCon.setPlayer(kieranH);
        benC.setContract(benChenCon);

        contractRepo.saveAll(Arrays.asList(leAnneCon, seanGCon, amiCon, dbbCon, keriAnnCon, cmContract, jjContract, jiYoungContract, siYuContract, benSchantzContract, kieranCon, dannaCon, sarahHCon, heatherSCon, benChenCon));


        leAnne.setContract(leAnneCon);
        seanG.setContract(seanGCon);
        kj.setContract(cmContract);
        jenJ.setContract(jjContract);
        jiYoung.setContract(jiYoungContract);
        kieranH.setContract(kieranCon);
        danna.setContract(dannaCon);

        ArrayList<String> partsOrder = new ArrayList(Arrays.asList("Piccolo", "Flute", "Alto Flute", "Oboe", "English Horn", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Sax",
                "Bassoon", "Contra", "Horn", "Trumpet", "Trombone", "Bass Trombone", "Euphonium", "Tuba", "Timpani", "Percussion",
                "Harp", "Piano", "Keyboard", "Violin 1", "Violin 2", "Viola", "Cello", "Bass"));


        List<Part> flutes = new ArrayList<>();
        flutes.add(Part.Flute);

        List<Part> oboes = new ArrayList<>();
        oboes.add(Part.Oboe);

        List<Part> violins = new ArrayList<>();
        violins.add(Part.Violin1);

        List<Part> basses = new ArrayList<>();
        basses.add(Part.Bass);

        List<Part> violas = new ArrayList<>();
        violas.add(Part.Viola);

        leAnne.setParts(flutes);
        seanG.setParts(flutes);
        sarahH.setParts(oboes);
        kieranH.setParts(basses);
        jenJ.setParts(violins);
        sy.setParts(violas);
        danna.setParts(oboes);


        playerRepo.saveAll(Arrays.asList(leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
                eriS, ee, jiYoung, ln, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV));


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
