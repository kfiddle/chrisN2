package com.example.demo.controllers;

import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.repositories.PieceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
