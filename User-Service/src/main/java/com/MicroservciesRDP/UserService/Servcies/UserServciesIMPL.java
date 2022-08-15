package com.MicroservciesRDP.UserService.Servcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MicroservciesRDP.UserService.DAO.UserRepository;
import com.MicroservciesRDP.UserService.Entity.User;
import com.MicroservciesRDP.UserService.Helper.Contact;
import com.MicroservciesRDP.UserService.Helper.ResponseTemplateVO;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServciesIMPL implements UserServcies {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void saveUserDetails(User user) {
		this.userRepository.save(user);
	}

//	reteriving contact using rest template

	@Override
	public ResponseTemplateVO getUserDetails(int userId) {
		ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
		User user=userRepository.findByUserId(userId);
		ResponseEntity<List<Contact>> responseEntity=
				restTemplate.exchange("http://localhost:9092/contacts/"+user.getUserId(), HttpMethod.GET,
						null,new ParameterizedTypeReference<List<Contact>>() {});
		List<Contact> users = responseEntity.getBody();

		responseTemplateVO.setUser(user);
		responseTemplateVO.setContact(users);
		return responseTemplateVO;
	}

//	Add a contact using rest template
	@Override
	public ResponseTemplateVO addUserDetails(ResponseTemplateVO responseTemplateVO) {
		User user=responseTemplateVO.getUser();
		List<Contact> contacts=responseTemplateVO.getContact();
		userRepository.save(user);
		for(Contact contact:contacts){
			restTemplate.postForEntity("http://localhost:9092/contacts/",contact, Contact.class);
		}

		return responseTemplateVO;
	}

}
