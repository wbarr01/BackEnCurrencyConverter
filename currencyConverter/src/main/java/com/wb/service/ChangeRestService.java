package com.wb.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.wb.data.ChangeData;
import com.wb.dto.Change;
import com.wb.dto.ChangeResponse;

@Path("/change")
public class ChangeRestService {
	
	@GET
    @Path("/{base}")
    @Produces(MediaType.APPLICATION_JSON)
    public ChangeResponse getConvert(@PathParam("base") String base) {
		 ArrayList<Change> changeList = new ArrayList<Change>();
		 ChangeResponse chResponse = null;
		  if(base!=null && base.length()>0){
				try
				{	
					changeList = ChangeData.getConvert(base);
					if(changeList !=null && changeList.size()>0){
						//fomating Json as proptotype
						chResponse = new ChangeResponse();
						chResponse.setBase(changeList.get(0).getBase());
						chResponse.setDate(changeList.get(0).getCreateDate());
						for ( Change change : changeList){
							chResponse.getRates().put(change.getRateName(), change.getRateValue());
						}
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		  }
		return chResponse;
    }
	
	@GET
    @Path("/{base}/{symbols}")
    @Produces(MediaType.APPLICATION_JSON)
    public ChangeResponse getConvertEUR(@PathParam("base") String base, @PathParam("symbols") String symbols) {
		Change change = new Change();
		ChangeResponse chResponse = null;
		if(base!=null && base.length()>0 && symbols!=null && symbols.length()>0)
			try
			{
				change = ChangeData.getConvertEUR(base,symbols);
				if(change !=null){
					//fomating Json as proptotype
					chResponse = new ChangeResponse();
					chResponse.setBase(change.getBase());
					chResponse.setDate(change.getCreateDate());
					chResponse.getRates().put(change.getRateName(), change.getRateValue());
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return chResponse;
    }
}
