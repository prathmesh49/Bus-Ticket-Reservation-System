package com.redbus.dao;

import com.redbus.dto.Booking;
import com.redbus.exception.SomeThingWentWrongException;

public interface BookingDao {
	
	public void bookBus(Booking bookInfo) throws SomeThingWentWrongException; 

}
