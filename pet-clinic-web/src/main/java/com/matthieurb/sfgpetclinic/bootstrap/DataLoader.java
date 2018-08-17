package com.matthieurb.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matthieurb.sfgpetclinic.model.Owner;
import com.matthieurb.sfgpetclinic.model.Vet;
import com.matthieurb.sfgpetclinic.services.OwnerService;
import com.matthieurb.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;

	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {
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
