package com.in.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.in.model.Movie;
import com.in.util.Utility;

@Service
public class OmdbService {

	@Value(value = "${omdb:default}")
	private String omdbUrl;

	public Movie searchApi(String text) throws IOException {

		String charset = "UTF-8";
		URL url = new URL(omdbUrl + text);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", charset);
		// con.setRequestProperty("Content-Type", "application/json");
		// con.setConnectTimeout(5000);
		// con.setReadTimeout(5000);

		InputStream response = con.getInputStream();

		return createResponse(Utility.convertToJson(response));
	}

	private Movie createResponse(HashMap<String, String> map) {
		Movie movie = new Movie();
		movie.setCountry(map.get("Country"));
		movie.setGenre(map.get("Genre"));
		movie.setImdbID(map.get("imdbID"));
		movie.setImdbRating(map.get("imdbRating"));
		movie.setTitle(map.get("Title"));
		movie.setYear(Integer.parseInt(map.get("Year")));

		return movie;

	}

}
