package com.redbus.dto;

import java.time.LocalDateTime;

public class BookingIMPL implements Booking {
	private int ticketNo;
	private int passID;
	private int busID;
	private int noOfTickete;
	private LocalDateTime dateTime;

	public BookingIMPL() {
	}

	public BookingIMPL(int ticketNo, int passID, int busID, int noOfTickete, LocalDateTime dateTime) {
		this.ticketNo = ticketNo;
		this.passID = passID;
		this.busID = busID;
		this.noOfTickete = noOfTickete;
		this.dateTime = dateTime;
	}

	@Override
	public int getTicketNo() {
		return ticketNo;
	}

	@Override
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public int getPassID() {
		return passID;
	}

	@Override
	public void setPassID(int passID) {
		this.passID = passID;
	}

	@Override
	public int getBusID() {
		return busID;
	}

	@Override
	public void setBusID(int busID) {
		this.busID = busID;
	}

	@Override
	public int getNoOfTickete() {
		return noOfTickete;
	}

	@Override
	public void setNoOfTickete(int noOfTickete) {
		this.noOfTickete = noOfTickete;
	}

	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
