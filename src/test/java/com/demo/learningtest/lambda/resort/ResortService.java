package com.demo.learningtest.lambda.resort;

import java.util.List;

public interface ResortService {
	public List<String> findGuestNamesByCompany(String company);
	public List<String> findGuestNamesByGrade(int grade);
}
