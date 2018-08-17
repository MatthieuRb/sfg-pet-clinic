package com.matthieurb.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {
	
	private Set<Specialty> spetialties;

	public Set<Specialty> getSpetialties() {
		return spetialties;
	}

	public void setSpetialties(Set<Specialty> spetialties) {
		this.spetialties = spetialties;
	}

}
