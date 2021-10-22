package com.example.demo;


import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PerformancePieceRepository;
import com.example.demo.repositories.PerformanceRepository;
import com.example.demo.repositories.PieceRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JPAWiringTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PerformanceRepository performanceRepo;

    @Autowired
    private PieceRepository pieceRepo;

    @Autowired
    private PerformancePieceRepository ppRepo;

    @Test
    public void shouldBeAbleToAddPP() {

        Performance testPerformance1 = new Performance();
        performanceRepo.save(testPerformance1);

        Piece testPiece1 = new Piece();
        Piece testPiece2 = new Piece();
        Piece testPiece3 = new Piece();
        Piece testPiece4 = new Piece();

        pieceRepo.save(testPiece1);
        pieceRepo.save(testPiece2);
        pieceRepo.save(testPiece3);
        pieceRepo.save(testPiece4);

        PerformancePiece firstPP = new PerformancePiece(testPerformance1, testPiece1);
        PerformancePiece secondPP = new PerformancePiece(testPerformance1, testPiece2);
//        PerformancePiece thirdPP = new PerformancePiece(testPerformance1, testPiece3);

        ppRepo.save(firstPP);
        ppRepo.save(secondPP);
//        ppRepo.save(thirdPP);        ppRepo.save(secondPP);


        Collection<Piece> piecesToTry = new ArrayList<>((Collection<? extends Piece>) pieceRepo.findAll());
        int flag = 0;

        for (Piece piece : piecesToTry) {
            if (!ppRepo.existsByPerformanceAndPiece(testPerformance1, piece)) {
                PerformancePiece ppToAdd = new PerformancePiece(testPerformance1, piece);
                ppRepo.save(ppToAdd);
                flag++;
            }
        }


            entityManager.flush();
            entityManager.clear();

            assertEquals(ppRepo.count(), 4);
            assertEquals(flag, 2);

        }

    }
