package com.ifmo.cs.kyoto.alaba4.dao;

import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsCrudRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByOwner(User owner);

}
