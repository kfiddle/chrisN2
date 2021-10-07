package com.example.demo.controllers;

import com.example.demo.models.Performance;
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

    @PostMapping("/add-piece")
    public Collection<Piece> addPieceToDatabase(@RequestBody Piece pieceToAdd) throws IOException {

        try {
            if (pieceToAdd.getComposerFirstName() != null) {
                if (!pieceRepo.existsByTitle(pieceToAdd.getTitle()) && !pieceRepo.existsByComposerLastName(pieceToAdd.getComposerLastName()) && !pieceRepo.existsByComposerFirstName(pieceToAdd.getComposerFirstName())) {
                    Piece newPiece = new Piece(pieceToAdd.getTitle(), pieceToAdd.getComposerFirstName(), pieceToAdd.getComposerLastName());
                    pieceRepo.save(newPiece);
                    System.out.println(newPiece.getComposerLastName() + "    " + newPiece.getComposerFirstName() + "   " + newPiece.getTitle());
                }
            } else {
                if (!pieceRepo.existsByTitle(pieceToAdd.getTitle()) && !pieceRepo.existsByComposerLastName(pieceToAdd.getComposerLastName())) {
                    Piece newPiece = new Piece(pieceToAdd.getTitle(), pieceToAdd.getComposerLastName());
                    pieceRepo.save(newPiece);
                    System.out.println(newPiece.getComposerLastName() + "    " + newPiece.getTitle());
                }
            }

        } catch (
                Exception error) {
            error.printStackTrace();
        }


        return (Collection<Piece>) pieceRepo.findAll();
    }


}
