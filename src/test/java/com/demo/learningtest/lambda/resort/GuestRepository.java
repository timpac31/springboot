package com.demo.learningtest.lambda.resort;

import java.util.List;

public interface GuestRepository {
	public void save(Guest ... guests);
	public List<Guest> findAll();
	public void deleteAll();
}
