package com.wb.data;

import com.wb.dto.Change;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChangeData {
	

	 public static ArrayList<Change> getConvert(String base) throws Exception {
		  //arreglar tema de connezcion y parametros
		 ArrayList<Change> changeList = new ArrayList<Change>();
		 DBconnection db = new DBconnection();
		 Connection con = db.getConnection();
		 ChangeDataRepo changeDataRepo = new ChangeDataRepo();
		 changeList = changeDataRepo.getChangeRates(con, base);
		 return changeList;
	 }
	 public static  Change getConvertEUR(String base, String symbols) throws Exception {
		  
		 Change change = new Change();
		 DBconnection db = new DBconnection();
		 Connection con = db.getConnection();
		 ChangeDataRepo changeDataRepo = new ChangeDataRepo();
		 change = changeDataRepo.getChangeRateEUR(con,base,symbols);
		 return change;
	 }
}
