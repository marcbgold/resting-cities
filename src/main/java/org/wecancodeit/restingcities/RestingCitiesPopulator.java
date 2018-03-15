package org.wecancodeit.restingcities;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestingCitiesPopulator implements CommandLineRunner {

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CityRepository cityRepo;

	@Override
	public void run(String... args) throws Exception {

		State ohio = stateRepo.save(new State("Ohio", "OH", "With God, all things are possible.", "none", "/states/oh/cities"));
		State newYork = stateRepo.save(new State("New York", "NY", "Excelsior!", "Brook Trout", "/states/ny/cities"));

		cityRepo.save(new City(ohio, "Columbus", 860090));
		cityRepo.save(new City(ohio, "Cleveland", 385809));
		cityRepo.save(new City(ohio, "Cincinnati", 298800));
		cityRepo.save(new City(newYork, "New York City", 8538000));
		cityRepo.save(new City(newYork, "Buffalo", 256902));
		cityRepo.save(new City(newYork, "South Fallsburg", 2870));

	}

}
