package com.ihsanerben.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String director;

    private int year;

    private String posterUrl;

    @ManyToMany(mappedBy = "favoriteMovies")
    private Set<User> usersWhoFavorited;
}
