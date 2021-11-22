package com.example.demo.repositories;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    boolean existsByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Player findByFirstNameAreaAndLastName(String firstNameArea, String lastName);

//    Collection<Player> findAllByContracted(boolean contracted);

    Collection<Player> findAllByHasContract(boolean hasContract);

    Collection<Player> findAllByType(Type sub);

//    Collection<Player> findByContractedAndPrimaryPart(boolean contracted, Part part);
}
