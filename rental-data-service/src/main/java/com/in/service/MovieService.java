package com.in.service;

import java.util.List;

import com.in.model.Movie;

public interface MovieService {

	Movie save(Movie movie);

	List<Movie> findAll();

}
