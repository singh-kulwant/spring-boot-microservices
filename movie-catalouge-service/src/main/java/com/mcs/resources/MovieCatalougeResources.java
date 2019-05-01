package com.mcs.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mcs.models.CatalougeItem;
import com.mcs.models.Movie;
import com.mcs.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalougeResources {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClient;

	@RequestMapping("/{userId}")
	public List<CatalougeItem> getCatalouge(@PathVariable("userId") String userId) {

		/* Get all movie Ids */
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating("001", 3));
		ratings.add(new Rating("002", 4));

		return ratings.stream().map(rating -> {

			Movie movie = restTemplate.getForObject("http://localhost:9090/movies/" + rating.getMovieId(), Movie.class);

			/*
			 * Webflux webcient impl
			 * 
			 * Movie movie = webClient.build() .get() .uri("http://localhost:9090/movies/" +
			 * rating.getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
			 */
			return new CatalougeItem(movie.getName(), "Default movie desc", rating.getRating());
		}).collect(Collectors.toList());

		// for each movie id, call movie info service and get details

		// put them all together

		// return Collections.singletonList(new CatalougeItem("Shutter Island", "fav
		// movie", 4));
	}
}
