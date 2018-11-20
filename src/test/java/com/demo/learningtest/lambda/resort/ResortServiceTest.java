package com.demo.learningtest.lambda.resort;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResortServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ResortServiceTest.class);
	
	private static GuestRepositoryMemory gr;
	private static Guest guest1, guest2, guest3, guest4;
	
	@BeforeClass
	public static void setup() {
		guest1 = new Guest(1, "jo", "moren");
		guest2 = new Guest(3, "kim", "moren");
		guest3 = new Guest(4, "lee", "futech");
		guest4 = new Guest(2, "park", "moren");
			
		gr = new GuestRepositoryMemory();
		gr.save(guest1, guest2, guest3, guest4);
	}
	
	@Test
	public void ClassicTest() {

		ResortServiceClassic resortService = new ResortServiceClassic();
		resortService.setGuestRepository(gr);
		List<String> names = resortService.findGuestNamesByCompany("moren");
		
		for(String name : names) {
			logger.info(name);
		}	
	}
	
	@Test
	public void lambdaTest() {
		ResortServiceLambda resortService = new ResortServiceLambda();
		resortService.setGuestRepository(gr);
		
		List<String> names = resortService.findGuestNamesByCompany("moren");
		for(String name : names) {
			logger.info(name);
		}
		
		List<String> names2 = resortService.findGuestNamesByGrade(1);
		for(String name : names2) {
			logger.info(name);
		}
		
	}
	

}
