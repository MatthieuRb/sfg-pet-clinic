package com.matthieurb.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
