package com.example.demo.repositories;

import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PerformancePiece_PlayerRepository extends CrudRepository<PerformancePiece_Player, Long> {
    Collection<PerformancePiece_Player> findAllByPerformancePiece(PerformancePiece incomingPP);

    boolean existsByPerformancePieceAndPlayer(PerformancePiece piece, Player player);

    Collection<PerformancePiece_Player> findAllByPerformancePieceAndPlayer(PerformancePiece piece, Player player);

}
