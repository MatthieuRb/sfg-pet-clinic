package com.matthieurb.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.matthieurb.sfgpetclinic.model.Vet;
import com.matthieurb.sfgpetclinic.services.SpecialtiesService;
import com.matthieurb.sfgpetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	private SpecialtiesService specialtiesService;

	public VetServiceMap(SpecialtiesService specialtiesService) {
		this.specialtiesService = specialtiesService;
	}

	@Override
	public Vet save(Vet object) {
		if(object.getSpecialties().size() > 0) {
			object.getSpecialties().forEach(specialty -> {
				if(specialty.getId() == null) {
					specialtiesService.save(specialty);
				}
			});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
