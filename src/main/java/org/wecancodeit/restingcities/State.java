package org.wecancodeit.restingcities;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	private String name;
	private String abbreviation;
	private String motto;

	@Embedded
	private Fish fish;
	private String citiesUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	@SuppressWarnings("unused")
	private State() {
	}

	public State(String name, String abbreviation, String motto, Fish fish, String citiesUrl) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.motto = motto;
		this.fish = fish;
		this.citiesUrl = citiesUrl;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getMotto() {
		return motto;
	}

	public Fish getFish() {
		return fish;
	}

	public String getCitiesUrl() {
		return citiesUrl;
	}

	public Collection<City> getCities() {
		return cities;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((State) obj).id;
	}

}
