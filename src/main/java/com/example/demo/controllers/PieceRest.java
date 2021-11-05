package com.example.demo.controllers;

import com.example.demo.models.Piece;
import com.example.demo.repositories.PieceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

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
            boolean condition1 = pieceRepo.existsByTitleAndComposerLastName(pieceToAdd.getTitle(), pieceToAdd.getComposerLastName());
            if (pieceToAdd.getComposerFirstName() != null) {
                condition1 = pieceRepo.existsByTitleAndComposerLastNameAndComposerFirstName(pieceToAdd.getTitle(), pieceToAdd.getComposerLastName(), pieceToAdd.getComposerFirstName());
            }
            if (!condition1) {
                Piece newPiece = new Piece();
                newPiece.setAllProps(pieceToAdd);
                pieceRepo.save(newPiece);
                System.out.println(newPiece.getComposerLastName() + "    " + newPiece.getComposerFirstName() + newPiece.getLibNumber());

            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }

}
