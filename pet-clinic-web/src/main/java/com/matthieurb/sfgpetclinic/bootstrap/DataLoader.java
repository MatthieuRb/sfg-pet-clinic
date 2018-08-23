package com.matthieurb.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matthieurb.sfgpetclinic.model.Owner;
import com.matthieurb.sfgpetclinic.model.Pet;
import com.matthieurb.sfgpetclinic.model.PetType;
import com.matthieurb.sfgpetclinic.model.Specialty;
import com.matthieurb.sfgpetclinic.model.Vet;
import com.matthieurb.sfgpetclinic.model.Visit;
import com.matthieurb.sfgpetclinic.services.OwnerService;
import com.matthieurb.sfgpetclinic.services.PetService;
import com.matthieurb.sfgpetclinic.services.PetTypeService;
import com.matthieurb.sfgpetclinic.services.SpecialtiesService;
import com.matthieurb.sfgpetclinic.services.VetService;
import com.matthieurb.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtiesService specialtiesService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtiesService specialtiesService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtiesService = specialtiesService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if(count==0) {
			loadData();
		}
	}
	
	private void loadData() {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setPrenom("Michael");
		owner1.setNom("Weston");
		owner1.setAddress("45 Rue Machin");
		owner1.setCity("Nantes");
		owner1.setTelephone("064654164");
		
		Pet mikesPet = new Pet();
		mikesPet.setName("Wouf");
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setOwner(owner1);
		mikesPet.setPetType(savedDogPetType);
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setPrenom("Jean");
		owner2.setNom("Claude");
		owner2.setAddress("47 Rue Machin");
		owner2.setCity("Nantes");
		owner2.setTelephone("3516165516");
		
		Pet jeansPet = new Pet();
		jeansPet.setName("Miaou");
		jeansPet.setBirthDate(LocalDate.now());
		jeansPet.setOwner(owner2);
		jeansPet.setPetType(savedCatPetType);
		owner2.getPets().add(jeansPet);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(jeansPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Visite du chat");
		visitService.save(catVisit);
		
		System.out.println("Loeaded Owners ...");
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Service de radiologie");
		specialtiesService.save(radiology);
		
		Specialty surgency = new Specialty();
		surgency.setDescription("Service des urgences");
		specialtiesService.save(surgency);
		
		Vet vet1 = new Vet();
		vet1.setNom("Dupond");
		vet1.setPrenom("Patrick");
		vet1.getSpecialties().add(radiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setNom("Rambaud");
		vet2.setPrenom("Mat");
		vet2.getSpecialties().add(surgency);
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets ...");
		
	}
	
}
