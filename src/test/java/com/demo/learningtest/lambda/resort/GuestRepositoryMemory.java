package com.demo.learningtest.lambda.resort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuestRepositoryMemory implements GuestRepository {
	private List<Guest> Guests = new ArrayList<Guest>();

	@Override
	public void save(Guest... guests) {
		this.Guests.addAll(Arrays.asList(guests));
	}

	@Override
	public List<Guest> findAll() {
		return this.Guests;
	}

	@Override
	public void deleteAll() {
		this.Guests.clear();
	}
	
}
