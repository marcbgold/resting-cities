package org.wecancodeit.restingcities;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String abbreviation;
	private String motto;
	private String fish;
	private String citiesUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	public State() {
	}

	public State(String name, String abbreviation, String motto, String fish, String citiesUrl, City... cities) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.motto = motto;
		this.fish = fish;
		this.citiesUrl = citiesUrl;
		this.cities = Arrays.asList(cities);
	}

}
