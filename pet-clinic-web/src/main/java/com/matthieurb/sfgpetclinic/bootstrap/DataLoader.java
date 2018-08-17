package com.matthieurb.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matthieurb.sfgpetclinic.model.Owner;
import com.matthieurb.sfgpetclinic.model.Pet;
import com.matthieurb.sfgpetclinic.model.PetType;
import com.matthieurb.sfgpetclinic.model.Vet;
import com.matthieurb.sfgpetclinic.services.OwnerService;
import com.matthieurb.sfgpetclinic.services.PetTypeService;
import com.matthieurb.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		
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
		
		System.out.println("Loeaded Owners ...");
		
		Vet vet1 = new Vet();
		vet1.setNom("Dupond");
		vet1.setPrenom("Patrick");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setNom("Rambaud");
		vet2.setPrenom("Mat");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets ...");
		
	}
	
}
