package com.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
