package com.flight.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.Flight;
import com.flight.model.FlightBookingDetails;

import io.jsonwebtoken.lang.Collections;

@CrossOrigin()
@RestController
@RequestMapping({ "/flightbook" })
public class FlightBookingController {

	@Autowired
	private FlightBookingRepository fbr;
  public List<FlightBookingDetails> bookList=new ArrayList<FlightBookingDetails>();
	@PostMapping(produces = "application/json")
	public List<Flight> firstPage(@RequestBody Flight flight,@RequestBody List<Flight> flights) {
		//String id=flight.getFlightId();
		return flights.stream().map(f-> {if( f.getFlightId()==flight.getFlightId()){
			f.setSeat( f.getSeat() -f.getBookedSeat());
			return f ;
		}
		else 
			return f;
		}).collect(Collectors.toList());
		//return flights;
	}
	
	
	@PostMapping(path ="/book",produces = "application/json")
	public List<FlightBookingDetails> bookPage(@RequestBody FlightBookingDetails book) {
		bookList.add(book);
		fbr.save(book);
		return bookList;
	}

	
	
	@GetMapping(path ="/get",produces = "application/json")
	public List<FlightBookingDetails> getBookingPage() {
		 return fbr.findAll();
		//return bookList;
	}

	

}