package com.matthieurb.sfgpetclinic.services;

import java.util.Set;

import com.matthieurb.sfgpetclinic.model.Owner;
import com.matthieurb.sfgpetclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();

}
