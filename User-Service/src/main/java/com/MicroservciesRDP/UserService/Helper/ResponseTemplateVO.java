package com.MicroservciesRDP.UserService.Helper;

import com.MicroservciesRDP.UserService.Entity.User;

import java.util.List;

public class ResponseTemplateVO {
	public User user;
	public List<Contact> contact;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
}
