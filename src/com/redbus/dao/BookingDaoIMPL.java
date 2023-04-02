package com.redbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.redbus.dto.Booking;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class BookingDaoIMPL implements BookingDao {

	@Override
	public void bookBus(Booking bookInfo) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "INSERT INTO bookinginfo (pasID, busID, noOfTickets, bookingDate, isCancel)"
					+ "VALUES (?, ?, ?, NOW(), 1)";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setInt(1, bookInfo.getPassID());
			ps.setInt(2, bookInfo.getBusID());
			ps.setInt(3, bookInfo.getNoOfTickete());
			
			if (ps.executeUpdate() > 0) {
				System.out.println("Ticket booked!");
			} else {
				System.out.println("Tickete cannot booked!");
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in bookBus " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
		
	}
	
	public void updateIsCancel(int bookid) throws SomeThingWentWrongException, NoRecordFoundException{
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "UPDATE bookinginfo SET isCancel = 0 WHERE bookingID = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setInt(1, bookid);
			
			if (ps.executeUpdate() > 0) {
				System.out.println("Ticket canceled!");
			} else {
				System.out.println("Operation Failed!");
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in bookBus " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
	}

}
