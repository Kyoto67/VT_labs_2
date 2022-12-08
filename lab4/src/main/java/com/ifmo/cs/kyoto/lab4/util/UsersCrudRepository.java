package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersCrudRepository extends CrudRepository<User, Long> {
}
