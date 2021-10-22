package com.example.demo.repositories;

import com.example.demo.junctionTables.PerformancePiece;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PerformancePieceRepository extends CrudRepository<PerformancePiece, Long> {

    Collection<PerformancePiece> findAllByPerformance(Performance performance, Sort orderNumber);

    Collection<PerformancePiece> findAllByPerformance(Performance performance);

    boolean existsByPerformanceAndPiece(Performance performance, Piece piece);

    boolean existsByPerformanceIdAndPiece(Long performanceId, Piece piece);
}
