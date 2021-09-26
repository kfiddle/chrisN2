package com.example.demo.repositories;

import com.example.demo.models.Instrument;
import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrument, Long> {

    boolean existsByName(String name);

    Instrument findByName(String name);
}
