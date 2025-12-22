package com.ihsanerben.controller;

import com.ihsanerben.entity.Movie;
import com.ihsanerben.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/public")
    public List<Movie> getPublicMovies() {
        return movieService.getPublicMovies();
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PostMapping("/{movieId}/favorite")
    public void addFavorite(@PathVariable Long movieId,
                            Authentication authentication) {
        movieService.addFavorite(authentication.getName(), movieId);
    }

    @DeleteMapping("/{movieId}/favorite")
    public void removeFavorite(@PathVariable Long movieId,
                               Authentication authentication) {
        movieService.removeFavorite(authentication.getName(), movieId);
    }
}
