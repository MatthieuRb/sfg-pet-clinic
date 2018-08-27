package com.matthieurb.sfgpetclinic.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
	
	public Person(Long id, String prenom, String nom) {
		super(id);
		this.prenom = prenom;
		this.nom = nom;
	}

	@Column(name="prenom")
	private String prenom;
	
	@Column(name="nom")
	private String nom;	

}
