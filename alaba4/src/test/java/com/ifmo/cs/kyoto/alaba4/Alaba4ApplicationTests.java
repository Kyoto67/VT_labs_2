package com.ifmo.cs.kyoto.alaba4;

import com.ifmo.cs.kyoto.alaba4.dao.ResultsCrudRepository;
import com.ifmo.cs.kyoto.alaba4.dao.UsersCrudRepository;
import com.ifmo.cs.kyoto.alaba4.dto.HitDTO;
import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.service.ResultPackageService;
import com.ifmo.cs.kyoto.alaba4.service.ResultService;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Alaba4ApplicationTests {

    @Autowired
    UsersService usersService;
    @Autowired
    ResultService resultService;
    @Autowired
    ResultPackageService resultPackageService;
    @Autowired
    ResultsCrudRepository resultsCrudRepository;
    @Autowired
    UsersCrudRepository usersCrudRepository;


    @BeforeAll
    void addMyUser(){
        User user = new User("GOIDA", "BROTHERSandSISTERS");
        Result result1 = resultPackageService.service(user, new HitDTO(2, 2, 3)).getResult();
        Result result2 = resultPackageService.service(user, new HitDTO(1, 1, 2)).getResult();
        usersCrudRepository.save(user);
        resultsCrudRepository.save(result1);
        resultsCrudRepository.save(result2);
    }

    @Test
    void checkMyUser(){
        assertThat(usersCrudRepository.findByUsername("GOIDA").getPassword()).isEqualTo("BROTHERSandSISTERS");
    }

    @Test
    void checkWrongUser(){
        assertThat(usersCrudRepository.findByUsername("ZZVV")).isNull();
    }

    @Test
    void testEntities(){
        User user = usersCrudRepository.findByUsername("GOIDA");
        assertThat(resultsCrudRepository.findByOwner(user)).hasSize(2);
        resultsCrudRepository.deleteByOwner(user);
        assertThat(resultsCrudRepository.findByOwner(user)).hasSize(0);
    }
}
