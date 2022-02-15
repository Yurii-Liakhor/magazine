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
    @Column
    private String login;
    @Column
    private String name;
//    @Column
//    todo pass

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_magazine",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "magazine_id")
    )
    private Set<Magazine> magazines;
}
