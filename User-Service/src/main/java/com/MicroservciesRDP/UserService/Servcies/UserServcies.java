package com.MicroservciesRDP.UserService.Servcies;

import com.MicroservciesRDP.UserService.Entity.User;
import com.MicroservciesRDP.UserService.Helper.ResponseTemplateVO;

public interface UserServcies {

	public void saveUserDetails(User user);
	public ResponseTemplateVO getUserDetails(int userId);

    ResponseTemplateVO addUserDetails(ResponseTemplateVO responseTemplateVO);
}
