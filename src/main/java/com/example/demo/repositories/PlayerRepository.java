package com.example.demo.repositories;

import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    boolean existsByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Collection<Player> findByType(Type type, Sort by);

    Player findByFirstNameAreaAndLastName(String firstNameArea, String lastName);

}
