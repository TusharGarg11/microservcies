package com.MicroservciesRDP.ContactServcies.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MicroservciesRDP.ContactServcies.Entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
