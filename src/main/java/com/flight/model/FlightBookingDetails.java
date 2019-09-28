package com.flight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FlightBookingDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private String flightId;
	private String name;
	private String source;
	private String destination;
	private int seat;
	private int bookedSeat;
	private String date;
	private int amount;
	private String paxName;
	private String paxEmail;
	private String paxCardNumber;
	private String paxAge;


	

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaxName() {
		return paxName;
	}

	public void setPaxName(String paxName) {
		this.paxName = paxName;
	}

	public String getPaxEmail() {
		return paxEmail;
	}

	public void setPaxEmail(String paxEmail) {
		this.paxEmail = paxEmail;
	}

	public String getPaxCardNumber() {
		return paxCardNumber;
	}

	public void setPaxCardNumber(String paxCardNumber) {
		this.paxCardNumber = paxCardNumber;
	}

	public String getPaxAge() {
		return paxAge;
	}

	public void setPaxAge(String paxAge) {
		this.paxAge = paxAge;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public FlightBookingDetails() {
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	

}