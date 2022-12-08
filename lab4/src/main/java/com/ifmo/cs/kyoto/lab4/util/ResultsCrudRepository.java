package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsCrudRepository extends CrudRepository<Result, Long> {

}
