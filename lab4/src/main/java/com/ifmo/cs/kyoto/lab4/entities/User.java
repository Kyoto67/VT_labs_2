package com.ifmo.cs.kyoto.lab4.entities;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String username;
    private String password;

    @UniqueElements
    private String VKid;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Result> results;

}
