package com.wb.data;

import java.sql.Connection;
import java.sql.SQLException;

import com.wb.dto.User;

public class UserData {
	
	public User login( String username, String password) throws Exception{
		DBconnection db = new DBconnection();
		Connection con = db.getConnection();
		UserDataRepo userDataRepo = new UserDataRepo();
		User user = null;
		user = userDataRepo.login(con, username, password);
		return user;
	}
}
