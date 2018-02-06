package com.wb.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wb.data.UserData;
import com.wb.dto.UserResponse;
import com.wb.dto.User;
import com.wb.dto.UserRequest;
@Path("/authenticate")

public class UserRestService {

	@POST
	@Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
	public UserResponse login(UserRequest userReq){
		UserResponse uResponse= new UserResponse();
		if(userReq.getUsername()!=null && userReq.getUsername().length()>0 && userReq.getPassword()!=null && userReq.getPassword().length()>0){
			try
			{
				UserData uData= new UserData();	
				User user=uData.login(userReq.getUsername(), userReq.getPassword());
				if (user != null){
					uResponse.setUsername(user.getUsername());
				}else uResponse.setErrorMsg("Username or Password Incorrect.");
			}catch(Exception ex){
				uResponse.setErrorMsg("Something went wrong with operation, please try again.");
			}
		}else  uResponse.setErrorMsg("Username and Password must have a value.");
		return uResponse;
	}
}
