package com.mcs.resources;


import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalougeResources {

	@RequestMapping("/{userId}")
	public List<CatalougeItem> getCatalouge(@PathVariable("userId") String userId) {
		
		return Collections.singletonList(new CatalougeItem("Shutter Island", "fav movie", 4));
	}
}
