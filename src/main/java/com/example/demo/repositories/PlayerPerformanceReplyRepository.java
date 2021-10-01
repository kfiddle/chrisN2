package com.example.demo.repositories;

import com.example.demo.junctionTables.PlayerPerformanceReply;
import com.example.demo.models.Performance;
import com.example.demo.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlayerPerformanceReplyRepository extends CrudRepository<PlayerPerformanceReply, Long> {

    PlayerPerformanceReply findByPlayerAndPerformance(Player player, Performance performance);

    boolean existsByPlayerAndPerformance(Player player, Performance performance);

    Collection<PlayerPerformanceReply> findAllByPerformance(Performance performance);

    Collection<PlayerPerformanceReply>  findAllByPerformanceAndAvailable(Performance performance, boolean isAvailable);
}
