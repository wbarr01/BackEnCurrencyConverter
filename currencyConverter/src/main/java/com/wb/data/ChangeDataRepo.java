package com.wb.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wb.dto.Change;

public class ChangeDataRepo {
	
	public ArrayList<Change> getChangeRates(Connection con, String base) throws SQLException
	{
		ArrayList<Change> changeList = new ArrayList<Change>();
		PreparedStatement stmt = con.prepareStatement("select idchange, base, rateName, ratevalue, date_format(createdate, '%y-%m-%d') as createdate from MONEYCHANGE.change where base = ?");
		stmt.setString(1, base);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Change change = new Change();
				change.setIdChange(rs.getInt("idChange"));
				change.setBase(rs.getString("base"));
				change.setRateName(rs.getString("rateName"));
				change.setRateValue(rs.getDouble("rateValue"));
				change.setCreateDate(rs.getString("createDate"));
				changeList.add(change);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
		    try { rs.close(); } catch (Exception e) {  }
		    try { stmt.close(); } catch (Exception e) {  }
		    try { con.close(); } catch (Exception e) {  }
		}
		return changeList;
		 
	}
	public  Change getChangeRateEUR(Connection con, String base, String symbols) throws SQLException
	{
		Change change = null;
		PreparedStatement stmt = con.prepareStatement("select idchange, base, rateName, ratevalue, date_format(createdate, '%y-%m-%d') as createdate from MONEYCHANGE.change WHERE rateName= ? and base = ?");
		stmt.setString(1, symbols);
		stmt.setString(2, base);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				change = new Change();
				change.setIdChange(rs.getInt("idChange"));
				change.setBase(rs.getString("base"));
				change.setRateName(rs.getString("rateName"));
				change.setRateValue(rs.getDouble("rateValue"));
				change.setCreateDate(rs.getString("createDate"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
		    try { rs.close(); } catch (Exception e) {  }
		    try { stmt.close(); } catch (Exception e) {  }
		    try { con.close(); } catch (Exception e) {  }
		}
		return change;
		 
	}
}
