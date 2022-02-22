package com.example.magazine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table
@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "magazines")
    private List<User> users;
}
