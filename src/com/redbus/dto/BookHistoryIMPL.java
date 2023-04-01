package com.redbus.dto;

public class BookHistoryIMPL implements BookHistory {
	private int passID;
	private int busID;
	private String fullname;
	private String route;
	private String journeyTime;
	private int noOfSeats;
	private double totalFare;

	public BookHistoryIMPL() {
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
	public String getFullname() {
		return fullname;
	}

	@Override
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String getRoute() {
		return route;
	}

	@Override
	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String getJourneyTime() {
		return journeyTime;
	}

	@Override
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}

	@Override
	public int getNoOfSeats() {
		return noOfSeats;
	}

	@Override
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public double getTotalFare() {
		return totalFare;
	}

	@Override
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	
	

}
