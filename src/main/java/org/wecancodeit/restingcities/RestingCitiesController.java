package org.wecancodeit.restingcities;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestingCitiesController {

	@Resource
	StateRepository stateRepo;

	@Resource
	CityRepository cityRepo;

	@RequestMapping("/states")
	public Iterable<State> findAllStates() {
		return stateRepo.findAll();
	}

	@RequestMapping("/states/{abbreviation}")
	public State findOneState(@PathVariable String abbreviation) {
		return stateRepo.findByAbbreviationIgnoreCase(abbreviation);
	}

	@RequestMapping("/states/{abbreviation}/cities")
	public Iterable<City> findCitiesByState(@PathVariable String abbreviation) {
		State found = stateRepo.findByAbbreviationIgnoreCase(abbreviation);
		return found.getCities();
	}

}
