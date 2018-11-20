package com.demo.learningtest.lambda.resort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResortServiceLambda implements ResortService {
	private GuestRepository gr;
	public void setGuestRepository(GuestRepository guestRepository) {
		gr = guestRepository;
	}

	public List<String> findGuestNamesByCompany(String company) {
		List<Guest> guests = gr.findAll();
		return guests.stream()
				.filter(g -> company.equals(g.getCompany()))
				.sorted(Comparator.comparing(g -> g.getGrade()))
				.map(g -> g.getName()).collect(Collectors.toList());
	}
	
	public List<String> findGuestNamesByGrade(int grade) {
		List<Guest> guests = gr.findAll();
		return guests.stream().filter(g -> grade == g.getGrade()).sorted(Comparator.comparing(g->g.getName())).map(g->g.getName()).collect(Collectors.toList());
	}


}
