package com.example.demo.repositories;

import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PieceRepository extends CrudRepository<Piece, Long> {

    boolean existsByTitle(String title);

    boolean existsByComposer(String composer);

}
