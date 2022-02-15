package com.example.magazine.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Double price;

    @ManyToMany(mappedBy = "magazines")
    private List<User> users;
}
