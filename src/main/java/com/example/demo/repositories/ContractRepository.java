package com.example.demo.repositories;

import com.example.demo.models.Contract;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    Collection<Contract> findAll(Sort rank);
}
