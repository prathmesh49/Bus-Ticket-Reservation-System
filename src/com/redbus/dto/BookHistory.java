package com.redbus.dto;

public interface BookHistory {
	public int getBookID();

	public void setBookID(int bookID);

	public int getPassID();

	public void setPassID(int passID);

	public int getBusID();

	public void setBusID(int busID);

	public String getFullname();

	public void setFullname(String fullname);

	public String getRoute();

	public void setRoute(String route);

	public String getJourneyTime();

	public void setJourneyTime(String journeyTime);

	public int getNoOfSeats();

	public void setNoOfSeats(int noOfSeats);

	public double getTotalFare();

	public void setTotalFare(double totalFare);

	public String getStatus();

	public void setStatus(String status);
}
