package com.MicroservciesRDP.UserService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroservciesRDP.UserService.DAO.UserRepository;
import com.MicroservciesRDP.UserService.Entity.User;
import com.MicroservciesRDP.UserService.Helper.ResponseTemplateVO;
import com.MicroservciesRDP.UserService.Servcies.UserServcies;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServcies userServcies;
	
	@PostMapping("/")
	public ResponseEntity<HttpStatus> saveUserDetails(@RequestBody User user){
		try {
			this.userServcies.saveUserDetails(user);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	Get Request To display the User with contact
	@GetMapping("/{userId}")
	public ResponseTemplateVO getUserDetails(@PathVariable("userId") String userId) {
		return userServcies.getUserDetails(Integer.parseInt(userId));
	}

	//	post Request To display the User with contact
	@PostMapping("/addUser")
	public ResponseTemplateVO getUserDetails(@RequestBody ResponseTemplateVO responseTemplateVO) {
		return userServcies.addUserDetails(responseTemplateVO);
	}
	
}
