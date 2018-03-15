package org.wecancodeit.restingcities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
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

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

}
