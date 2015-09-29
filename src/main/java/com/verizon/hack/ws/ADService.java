package com.verizon.hack.ws;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.verizon.hack.db.MongoDBDAO;

@Path("/fetchAD")
public class ADService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	
	public String fetchAdsByPincode(@QueryParam("pincode")String pincode){
		String addDetails = null;
		MongoDBDAO mongo = new MongoDBDAO();
		JsonArray array = mongo.fetchAD(pincode);
		if(null != array){
			addDetails = array.toString();
		}
		return 	addDetails;
		
	}
}
