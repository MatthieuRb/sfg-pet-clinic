package com.matthieurb.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
