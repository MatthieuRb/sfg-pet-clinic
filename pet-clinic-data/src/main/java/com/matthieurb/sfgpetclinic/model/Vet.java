package com.matthieurb.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	
	private Set<Specialty> spetialties = new HashSet<Specialty>();

	public Set<Specialty> getSpetialties() {
		return spetialties;
	}

	public void setSpetialties(Set<Specialty> spetialties) {
		this.spetialties = spetialties;
	}

}
