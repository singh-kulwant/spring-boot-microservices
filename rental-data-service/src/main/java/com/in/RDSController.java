package com.in;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.model.Customer;
import com.in.model.Movie;
import com.in.service.CustomerService;
import com.in.service.MovieService;
import com.in.service.OmdbService;
import com.in.util.Utility;

@RestController
@RequestMapping(value = "/rental")
public class RDSController {

	@Autowired
	CustomerService customerService;

	@Autowired
	MovieService movieService;

	@Autowired
	OmdbService omdbService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String test() {
		return "hello";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer> findAllCust() {
		return customerService.findAll();
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public Movie addMovie(@RequestBody String search) throws IOException {
		return movieService.save(omdbService.searchApi(Utility.convertToJson(search)));
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public List<Movie> findAllMovie() {
		return movieService.findAll();
	}
}
