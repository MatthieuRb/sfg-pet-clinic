package com.matthieurb.sfgpetclinic.services;

import com.matthieurb.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);

}
