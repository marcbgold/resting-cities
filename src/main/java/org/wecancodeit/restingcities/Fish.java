package org.wecancodeit.restingcities;

import javax.persistence.Embeddable;

@Embeddable
public class Fish {

	private String fishName;
	private String scientificName;
	private String imageUrl;

	@SuppressWarnings("unused")
	private Fish() {
	}

	public Fish(String fishName, String scientificName, String imageUrl) {
		this.fishName = fishName;
		this.scientificName = scientificName;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return fishName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}
