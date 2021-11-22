package com.example.demo.controllers;

import com.example.demo.enums.Part;
import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PerformancePieceRepository;
import com.example.demo.repositories.PieceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class PieceRest {

    @Resource
    PieceRepository pieceRepo;

    @Resource
    PerformancePieceRepository ppRepo;

    @RequestMapping("/get-all-pieces")
    public Collection<Piece> getAllPerformances() {
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @RequestMapping("get-sorted-pieces/{sortType}")
    public Collection<Piece> getSortedPieces(@PathVariable String sortType) {
        try {
            return pieceRepo.findAllBy(Sort.by(sortType));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add-piece")
    public Collection<Piece> addPieceToDatabase(@RequestBody Piece pieceToAdd) throws IOException {

        try {
            if (!pieceRepo.existsByTitleAndComposerName(pieceToAdd.getTitle(), pieceToAdd.getComposerName())) {
                Piece newPiece = new Piece();
                newPiece.setAllProps(pieceToAdd);
                pieceRepo.save(newPiece);
                System.out.println(newPiece.getUpdated());
            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }


    @PostMapping("/add-full-orchestration")
    public Optional<Piece> addFullOrchestration(@RequestBody Piece incomingPiece) throws IOException {

        Optional<Piece> pieceCheck = pieceRepo.findById(incomingPiece.getId());
        if (pieceCheck.isPresent()) {
            Piece pieceToAttachOrch = pieceCheck.get();
            pieceToAttachOrch.setOrchestration(incomingPiece.getOrchestration());
            pieceRepo.save(pieceToAttachOrch);

            if (ppRepo.existsByPiece(pieceToAttachOrch)) {
                Collection<PerformancePiece> ppsToGetChairs = ppRepo.findAllByPiece(pieceToAttachOrch);
                for (PerformancePiece pp : ppsToGetChairs) {
                    pp.makeSomeEmptyChairs();
                    ppRepo.save(pp);
                }
            }
        }

        return pieceCheck;
    }


}
