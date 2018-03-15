package org.wecancodeit.restingcities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@ManyToOne
	@JsonIgnore
	private State state;
	private String name;
	private int population;

	@SuppressWarnings("unused")
	private City() {
	}

	public City(State state, String name, int population) {
		this.state = state;
		this.name = name;
		this.population = population;
	}

	public Long getId() {
		return id;
	}

	public State getState() {
		return state;
	}

	public String getStateName() {
		return state.getName();
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
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

		return id == ((City) obj).id;
	}

}
