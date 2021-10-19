package com.example.demo.repositories;

import com.example.demo.models.DateTime;
import com.example.demo.models.Performance;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface PerformanceRepository extends CrudRepository<Performance, Long> {

    Collection<Performance> findAll(Sort sort);

    boolean existsByTitle(String title);

//    boolean existsByDateTime(DateTime dateTime);
}
