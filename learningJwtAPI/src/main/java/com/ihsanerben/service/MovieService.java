package com.ihsanerben.service;

import com.ihsanerben.entity.Movie;
import com.ihsanerben.entity.User;
import com.ihsanerben.repository.MovieRepository;
import com.ihsanerben.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public List<Movie> getPublicMovies() {
        return movieRepository.findTop10ByOrderByIdAsc();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void addFavorite(String email, Long movieId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        user.getFavoriteMovies().add(movie);
        userRepository.save(user);
    }

    public void removeFavorite(String email, Long movieId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        user.getFavoriteMovies().remove(movie);
        userRepository.save(user);
    }
}
