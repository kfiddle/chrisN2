package com.example.demo.repositories;

import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PieceRepository extends CrudRepository<Piece, Long> {

    boolean existsByTitle(String title);

    boolean existsByComposerLastName(String composerLastName);

    boolean existsByComposerFirstName(String composerFirstName);

    boolean existsByTitleAndComposerLastNameAndComposerFirstName(String title, String composerLastName, String composerFirstName);

    boolean existsByTitleAndComposerLastName(String title, String composerLastName);

    Collection<Piece> findAllBy(Sort by);

}
