package com.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.Flight;
import com.flight.model.FlightBookingDetails;
import com.flight.controller.FlightRepository;

@CrossOrigin()
@RestController
@RequestMapping({ "/flight" })
public class FlightController {
	
	@Autowired
	private FlightBookingController fbc;
	 @Autowired
	    FlightRepository flightRepository;
	private List<Flight> flights = createList();

	@GetMapping(produces = "application/json")
	public List<Flight> firstPage() {
		System.out.println(fbc.bookList);
		for (Flight flight : flights) {
			
			int fid=flight.getFlightId();
		   int booked=0;
		for (FlightBookingDetails book : fbc.bookList) {
			System.out.println(book.getName());
			System.out.println(book.getPaxEmail());
			System.out.println(book.getFlightId());
			if(fid== Integer.valueOf(book.getFlightId())){
				 booked=booked + book.getBookedSeat();
			}
			flight.setSeat(flight.getSeat()-booked);
			flight.setBookedSeat(booked);

		}
		}
		//return flights;
		return flightRepository.findAll();
	}

	@DeleteMapping(path = { "/{id}" })
	public Flight delete(@PathVariable("id") int id) {
		Flight deletedFlight = null;
		for (Flight f : flights) {
			if (f.getFlightId()==id) {
				flights.remove(f);
				deletedFlight = f;
				break;
			}
		}
		return deletedFlight;
	}

	@PostMapping
	public Flight create(@RequestBody Flight flight) {
		flights.add(flight);
		 flightRepository.save(flight);
		return flight;
	}

	private static List<Flight> createList() {
		List<Flight> tempFlight = new ArrayList<>();
		Flight f1 = new Flight();
		f1.setName("ek001");
		f1.setSource("dxb");
		f1.setDestination("ny");
		f1.setSeat(100);
		f1.setFlightId(1);
		f1.setDate("2019-09-29");
		f1.setAmount(1000);
		

		
		Flight f2 = new Flight();
		f2.setName("ek002");
		f2.setSource("lhr");
		f2.setDestination("dxb");
		f2.setSeat(50);
		f2.setFlightId(2);
		f2.setDate("2019-09-30");
		f2.setAmount(1100);
		tempFlight.add(f1);

		tempFlight.add(f2);
		
		return tempFlight;
	}

}