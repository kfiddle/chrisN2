package com.example.demo.controllers;

import com.example.demo.models.NumbOnPart;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PieceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class PieceRest {

    @Resource
    PieceRepository pieceRepo;

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


    @PostMapping("/add-numb-on-part/{pieceId}")
    public Piece addNumberOnPart(@PathVariable Long pieceId, @RequestBody NumbOnPart incomingNumberPart) throws IOException {

        try {
            Optional<Piece> pieceCheck = pieceRepo.findById(pieceId);
            if (pieceCheck.isPresent()) {
                Piece pieceToGetNum = pieceCheck.get();
                pieceToGetNum.addNumOnPart(incomingNumberPart);
                pieceRepo.save(pieceToGetNum);
//                System.out.println(pieceToGetNum.getTitle() + "   has: " + pieceToGetNum.getOrchestration().size());
            }

        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}
