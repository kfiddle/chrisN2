package com.example.demo.repositories;

import com.example.demo.junctionTables.PlayerPerformanceReply;
import com.example.demo.models.Performance;
import com.example.demo.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerPerformanceReplyRepository extends CrudRepository<PlayerPerformanceReply, Long> {

    PlayerPerformanceReply findByPlayerAndPerformance(Player player, Performance performance);

    boolean existsByPlayerAndPerformance(Player player, Performance performance);
}
