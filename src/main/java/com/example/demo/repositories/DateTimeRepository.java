package com.example.demo.repositories;

import com.example.demo.models.DateTime;
import org.springframework.data.repository.CrudRepository;

public interface DateTimeRepository extends CrudRepository<DateTime, Long> {

}
