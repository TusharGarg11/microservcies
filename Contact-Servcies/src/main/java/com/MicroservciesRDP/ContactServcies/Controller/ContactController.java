package com.MicroservciesRDP.ContactServcies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroservciesRDP.ContactServcies.Entity.Contact;
import com.MicroservciesRDP.ContactServcies.Servcies.ContactServcies;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private ContactServcies contactServcies;
	
//	Post Request to save the contacts in the DB
	
	@PostMapping("/")
	public ResponseEntity<HttpStatus> saveContacts(@RequestBody Contact contacts){
		try {
			this.contactServcies.saveContact(contacts);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	Get Mapping to reterive the Contact from DB
	@GetMapping("/{CID}")
	public List<Contact> getContactDetails(@PathVariable("CID") String CID) {
		return contactServcies.getContactDetails(Integer.parseInt(CID));
	}
	
}
