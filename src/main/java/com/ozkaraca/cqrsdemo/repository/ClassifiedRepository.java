package com.ozkaraca.cqrsdemo.repository;

import com.ozkaraca.cqrsdemo.entity.Classified;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifiedRepository extends CrudRepository<Classified, Long> {
}
