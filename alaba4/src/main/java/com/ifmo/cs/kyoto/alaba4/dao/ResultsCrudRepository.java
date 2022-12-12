package com.ifmo.cs.kyoto.alaba4.dao;

import com.ifmo.cs.kyoto.alaba4.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsCrudRepository extends JpaRepository<Result, Long> {

}
