package com.verizon.hack.test.db;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.verizon.hack.db.MongoDBDAO;
import com.verizon.hack.domain.ADDetail;
import com.verizon.hack.domain.User;

public class MongoDBDAOTest {

	static User user;
	static User userregistered;
	static ADDetail ad;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userregistered = new User();
		MongoDBDAO mongo = new MongoDBDAO();
		userregistered.setUserName("lakshmi");
		userregistered.setPassword("pass");
		if(mongo.checkUser(user)){
			mongo.registerUser(userregistered);
		}
		ad = new ADDetail();
		ad.setBusinessName("XXX");
		ad.setAddr1("addr1");
		ad.setAddr2("addr2");
		ad.setAddr3("addr3");
		ad.setCity("city");
		ad.setState("state");
		ad.setCountry("country");
		ad.setPincode("zip");
		ad.setDesc("desc");
		ad.setUsername("username");
	}

	@Test
	public void testInsertEmptyADDDetails() {
		ADDetail detail = new ADDetail();
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.insertADDDetails(detail);
		assertEquals(false, result);
		
	}
	
	@Test
	public void testInsertADDDetailsEmptyBusiness() {
		ADDetail detail = new ADDetail();
		detail.setUsername("username");
		detail.setAddr1("addr1");
		detail.setPincode("600097");
		detail.setDesc("Great offer");
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.insertADDDetails(detail);
		assertEquals(false, result);
		
	}
	
	@Test
	public void testInsertADDDetailsEmptyPinCode() {
		ADDetail detail = new ADDetail();
		detail.setUsername("username");
		detail.setBusinessName("XXX");
		detail.setAddr1("addr1");		
		detail.setDesc("Great offer");
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.insertADDDetails(detail);
		assertEquals(false, result);
		
	}
	
	
	public void testInsertADDDetails() {		
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.insertADDDetails(ad);
		assertEquals(true, result);
		
	}

	
	public void testCheckUser() {
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.checkUser(userregistered);
		assertEquals(true, result);
	}

	
	public void testRegisterUser() {
		MongoDBDAO mongo = new MongoDBDAO();
		boolean result = mongo.checkUser(userregistered);
		assertEquals(true, result);
	}
	
	
	public void testFetchAD() {
		MongoDBDAO mongo = new MongoDBDAO();
		mongo.insertADDDetails(ad);		
		assertNotNull(mongo.fetchAD(ad.getPincode()));
	}

}
