package com.matthieurb.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByNom(String nom);

}