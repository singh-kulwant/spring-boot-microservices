package com.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.model.Movie;
import com.in.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

}
