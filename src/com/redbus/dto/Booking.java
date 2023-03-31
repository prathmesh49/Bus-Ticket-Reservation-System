package com.redbus.dto;

import java.time.LocalDateTime;

public interface Booking {
	public int getTicketNo();

	public void setTicketNo(int ticketNo);

	public int getPassID();

	public void setPassID(int passID);

	public int getBusID();

	public void setBusID(int busID);

	public int getNoOfTickete();

	public void setNoOfTickete(int noOfTickete);

	public LocalDateTime getDateTime();

	public void setDateTime(LocalDateTime dateTime);

}
