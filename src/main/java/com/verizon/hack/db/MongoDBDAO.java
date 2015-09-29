package com.verizon.hack.db;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.verizon.hack.domain.ADDetail;
import com.verizon.hack.domain.User;
import com.mongodb.MongoClientURI;

public class MongoDBDAO {

	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;
	
	static{
		try{
			initDBConnection();
		} catch(Exception e){
			throw e;
		}
	}
	
	private static void initDBConnection(){
		try{
			MongoClientURI uu = new MongoClientURI("mongodb://CloudFoundry_rt2ng8pk_tin9mr48_85ogqdj9:QJppO4eURNfKMVvd7tudJC_-ot4ufGGE@ds035633.mongolab.com:35633/CloudFoundry_rt2ng8pk_tin9mr48");
		
			mongoClient = new MongoClient(uu);
		//mongoClient = new MongoClient("localhost", 27017);
			if(null != mongoClient){
				mongoDatabase = mongoClient.getDatabase("CloudFoundry_rt2ng8pk_tin9mr48");	
				//mongoDatabase = mongoClient.getDatabase("ADdb");
			}
			
			System.out.println("Connection success");
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	/**
	 * This method is used to insert advertisement details into database
	 * @param ad
	 * @return
	 */
	public boolean insertADDDetails(ADDetail ad ){
		boolean result = false;
		MongoCursor<Document> curso = null;
		try{
			if(null != ad && null != ad.getUsername() && null != ad.getBusinessName()
					&& null != ad.getPincode()){
				MongoCollection<Document> collection = mongoDatabase.getCollection("ADlist");
				Document doc = new Document();
				doc.put("business", ad.getBusinessName());
				doc.put("addressL1", ad.getAddr1());
				doc.put("addressL2", ad.getAddr2());
				doc.put("addressL3", ad.getAddr3());
				doc.put("city", ad.getCity());
				doc.put("state", ad.getState());
				doc.put("country", ad.getCountry());
				doc.put("pincode", ad.getPincode());
				doc.put("desc", ad.getDesc());	
				doc.put("username", ad.getUsername());
				doc.put("filepath", ad.getFileFullPath());
				collection.insertOne(doc);
				result = true;
				/*BasicDBObject basic = new BasicDBObject("username",ad.getUsername());
				FindIterable<Document> cursor = collection.find(basic);
				if(null != cursor){
					curso = cursor.iterator();
					while(curso.hasNext()){
						System.out.println(curso.next());
					}
				}*/
			}
			} catch(Exception e){
				result = false;
				throw e;
			}
			finally{
				if(null != curso){
					curso.close();
				}
					
			}					
		return result;
	}
	
	public boolean checkUser(User user){
		boolean result = false;
		MongoCursor<Document> cur = null;
		try{
			if(null != user){
				MongoCollection<Document> collection = mongoDatabase.getCollection("userslist");
				BasicDBObject basic   = new BasicDBObject ("userName", user.getUserName());
				FindIterable<Document> cursor = collection.find(basic);
				if(null != cursor){
					cur = cursor.iterator();
					while(cur.hasNext()){
						Document doc = cur.next();
						String pwd = (String) doc.get("pwd");
						if(null != pwd && pwd.equalsIgnoreCase(user.getPassword())){
							result = true;
						}
					}
				}
			}
												
		}catch(Exception e){
			throw e;
		}
		return result;
	}
	
	public boolean registerUser(User user ){
		boolean result = true;		
		try{
			if(null != user){
				MongoCollection<Document> collection = mongoDatabase.getCollection("userslist");
				Document doc = new Document();
				doc.put("userName", user.getUserName());
				doc.put("pwd", user.getPassword());					
				collection.insertOne(doc);
			}			
						
		} catch(Exception e){
			result = false;
			throw e;
		}		
		return result;
	}
	
	public JsonArray fetchAD(String pincode){
		MongoCursor<Document> curso = null;
		MongoCollection<Document> collection = mongoDatabase.getCollection("ADlist");
		Document doc = null;
		JsonArray jarray = null;
		if(null != pincode && null != collection){
			BasicDBObject basic   = new BasicDBObject ("pincode", pincode);			
			FindIterable<Document> cursor = collection.find(basic);			
			if(null != cursor){
				JsonArrayBuilder jab = Json.createArrayBuilder();
				curso = cursor.iterator();
				while(curso.hasNext()){
					JsonObjectBuilder job = Json.createObjectBuilder(); 	
					doc = curso.next();
					job.add("username", null != doc.get("username") ? (String)doc.get("username") : "");
					job.add("business",  null !=doc.get("business")? (String)doc.get("business") : "");
					job.add("addressL1",  null !=doc.get("addressL1")? (String)doc.get("addressL1") : "");
					job.add("addressL2",  null !=doc.get("addressL2")? (String)doc.get("addressL2") : "");
					job.add("addressL3",  null !=doc.get("addressL3")? (String)doc.get("addressL3") : "");
					job.add("city",  null !=doc.get("city")? (String)doc.get("city") : "");
					job.add("state",  null !=doc.get("state")? (String)doc.get("state") : "");
					job.add("country",  null !=doc.get("country")? (String)doc.get("country") : "");
					job.add("pincode",  null !=doc.get("pincode")? (String)doc.get("pincode") : "");
					job.add("desc",  null !=doc.get("desc")? (String)doc.get("desc") : "");				
					JsonObject jo = job.build();
					jab.add(jo);
				}
				jarray = jab.build();
			}
		}
		
		return jarray;
	}
	
	
}
