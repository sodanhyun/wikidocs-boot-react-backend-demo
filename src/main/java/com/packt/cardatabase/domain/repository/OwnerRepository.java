package com.packt.cardatabase.domain.repository;

import com.packt.cardatabase.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}