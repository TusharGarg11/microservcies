package com.MicroservciesRDP.ContactServcies.Servcies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MicroservciesRDP.ContactServcies.DAO.ContactRepo;
import com.MicroservciesRDP.ContactServcies.Entity.Contact;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServciesIMPL implements ContactServcies {

	@Autowired
	private ContactRepo contactRepo;
	
//	Save Contact in the DB
	@Override
	public void saveContact(Contact contact) {
		this.contactRepo.save(contact);
	}

//	Reterive the contacts from the DB
	
	@Override
	public List<Contact> getContactDetails(int CID) {
		List<Contact> result=new ArrayList<>();
		for(Contact contact:contactRepo.findAll()){
			if(CID==contact.getUserId()){
				result.add(contact);
			}
		}
		return result;
	}

}
