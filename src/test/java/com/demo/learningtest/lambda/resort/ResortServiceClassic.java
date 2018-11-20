package com.demo.learningtest.lambda.resort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResortServiceClassic implements ResortService {
	private GuestRepository gr;
	public void setGuestRepository(GuestRepository guestRepository) {
		gr = guestRepository;
	}
	

	@Override
	public List<String> findGuestNamesByCompany(String company) {
		List<Guest> guests = gr.findAll();
		List<Guest> filteredGuest = findByCompany(guests, "moren");
		sortByGradeAsc(filteredGuest);
		return getNames(filteredGuest);
	}
	
	@Override
	public List<String> findGuestNamesByGrade(int grade) {
		List<Guest> guests = gr.findAll();
		List<Guest> filteredGuest = findByGrade(guests, grade);
		sortByGradeAsc(filteredGuest);
		return getNames(filteredGuest);
	}
	
	
	/**  해당 company의 guest만 추출*/
	private List<Guest> findByCompany(List<Guest> guests, String company) {
		List<Guest> result = new ArrayList<Guest>();
		for(Guest guest : guests) {
			if((company).equals(guest.getCompany())) {
				result.add(guest);
			}
		}
		return result;
	}
	
	private List<Guest> findByGrade(List<Guest> guests, int grade) {
		List<Guest> result = new ArrayList<Guest>();
		for(Guest guest : guests) {
			if(grade == guest.getGrade()) {
				result.add(guest);
			}
		}
		return result;
	}
	
	/** guests의 grade 오름차순으로 정렬한다 */
	private void sortByGradeAsc(List<Guest> guests) {
		Collections.sort(guests, new Comparator<Guest>() {
			public int compare(Guest o1, Guest o2) {
				return Integer.compare(o1.getGrade(), o2.getGrade());
			}
		});
	}
	
	/** guests의 name을 리턴한다 */
	private List<String> getNames(List<Guest> guests) {
		List<String> guestNames = new ArrayList<String>();
		for(Guest guest : guests) {
			guestNames.add(guest.getName());
		}
		return guestNames;
	}
	

}
