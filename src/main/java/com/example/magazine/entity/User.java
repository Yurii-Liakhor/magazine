package com.example.magazine.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String authority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_magazine",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "magazine_id")
    )
    private Set<Magazine> magazines;

    public boolean isMagazinesEmpty() {
        return magazines.isEmpty();
    }

    public boolean addMagazine(Magazine magazine) {
        return magazines.add(magazine);
    }

    public boolean removeMagazine(Object o) {
        return magazines.remove(o);
    }
}
