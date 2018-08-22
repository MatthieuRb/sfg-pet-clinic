package com.matthieurb.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.matthieurb.sfgpetclinic.model.Specialty;
import com.matthieurb.sfgpetclinic.repositories.SpecialtyRepository;
import com.matthieurb.sfgpetclinic.services.SpecialtiesService;

@Service
@Profile("springdatajpa")
public class SpecialtiesSDJpaService implements SpecialtiesService {
	
	private final SpecialtyRepository specialtyRepository;
	
	public SpecialtiesSDJpaService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<Specialty>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}
	
	

}
