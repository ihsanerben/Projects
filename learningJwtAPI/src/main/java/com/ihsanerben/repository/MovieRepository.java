package com.ihsanerben.repository;

import com.ihsanerben.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop10ByOrderByIdAsc();
}
