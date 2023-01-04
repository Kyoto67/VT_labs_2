package com.ifmo.cs.kyoto.alaba4.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
@Table(name = "users")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String username;
    private String password;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "owner")
    private List<Result> results;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public void addResult( Result result ) {
        if (results == null) {
            results = new ArrayList<>();
            results.add(result);
        } else {
            results.add(result);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        LinkedList<Role> roles = new LinkedList<>();
        roles.add(new Role());
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
