package com.wb.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wb.dto.Change;
import com.wb.dto.User;

public class UserDataRepo {

	public User login(Connection con, String username, String password) throws SQLException
	{
		User user = null;
		PreparedStatement stmt = con.prepareStatement("select * from MONEYCHANGE.user WHERE username= ? and password = ? and status=1");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
		    try { rs.close(); } catch (Exception e) {  }
		    try { stmt.close(); } catch (Exception e) {  }
		    try { con.close(); } catch (Exception e) {  }
		}
		return user;
	}	 
}
