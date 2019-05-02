package com.rds.resorces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rds.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingDataResorce {

	@RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
	
	@RequestMapping("users/{userId}")
	public List<Rating> getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating("001", 3));
		ratings.add(new Rating("002", 4));
		
		return ratings;
	}
}
