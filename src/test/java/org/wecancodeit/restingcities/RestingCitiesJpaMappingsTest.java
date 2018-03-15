package org.wecancodeit.restingcities;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RestingCitiesJpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CityRepository cityRepo;

	private static final String NAME = "name";
	private static final String ABBR = "AB";
	private static final String MOTTO = "motto";
	private static final String CITIES_URL = "url";
	private static final int POP = 1000;

	State state;
	City firstCity;
	City secondCity;
	Fish fish;

	@Before
	public void setup() {
		fish = new Fish(NAME, "fishus fishus", "image url");
		state = new State(NAME, ABBR, MOTTO, fish, CITIES_URL);
		firstCity = new City(state, "first", POP);
		secondCity = new City(state, "first", POP);
	}

	@Test
	public void shouldSaveAndLoadState() {
		state = stateRepo.save(state);
		long stateId = state.getId();

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getName(), is("name"));
	}

	@Test
	public void shouldSaveAndLoadCity() {
		state = stateRepo.save(state);
		firstCity = cityRepo.save(firstCity);
		long cityId = firstCity.getId();

		entityManager.flush();
		entityManager.clear();

		firstCity = cityRepo.findOne(cityId);
		assertThat(firstCity.getName(), is("first"));
	}

	@Test
	public void shouldEstablishManyCitiesToOneStateRelationship() {
		state = stateRepo.save(state);
		long stateId = state.getId();

		firstCity = cityRepo.save(firstCity);
		secondCity = cityRepo.save(secondCity);

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getCities(), containsInAnyOrder(firstCity, secondCity));
	}
}