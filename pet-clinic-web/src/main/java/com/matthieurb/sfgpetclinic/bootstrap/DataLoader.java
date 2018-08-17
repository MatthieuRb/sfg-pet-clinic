package com.matthieurb.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matthieurb.sfgpetclinic.model.Owner;
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
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setPrenom("Jean");
		owner2.setNom("Claude");
		
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
