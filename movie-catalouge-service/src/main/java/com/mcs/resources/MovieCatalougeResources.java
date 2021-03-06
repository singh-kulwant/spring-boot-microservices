package com.mcs.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mcs.models.CatalougeItem;
import com.mcs.models.Movie;
import com.mcs.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalougeResources {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/{userId}")
	public List<CatalougeItem> getCatalouge(@PathVariable("userId") String userId) {

		/* Get all movie Ids */
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratings/users/" + userId, UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {

			// for each movie id, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://movie-information-service/movies/" + rating.getMovieId(), Movie.class);

			/*
			 * Webflux webcient impl
			 * 
			 * Movie movie = webClient.build() .get() .uri("http://localhost:9090/movies/" +
			 * rating.getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
			 */
			
			// put them all together
			return new CatalougeItem(movie.getName(), "Default movie desc", rating.getRating());
		}).collect(Collectors.toList());

		
	
	}
}
