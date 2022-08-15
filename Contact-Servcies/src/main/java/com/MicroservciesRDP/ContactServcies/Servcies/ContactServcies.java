package com.MicroservciesRDP.ContactServcies.Servcies;

import com.MicroservciesRDP.ContactServcies.Entity.Contact;

import java.util.List;

public interface ContactServcies {
	public void saveContact(Contact contact);
	public List<Contact> getContactDetails(int CID);
}
