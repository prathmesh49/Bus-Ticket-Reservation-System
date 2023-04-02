package com.redbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.redbus.dto.BookHistory;
import com.redbus.dto.BookHistoryIMPL;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class BookHistoryDaoIMPL implements BookHistoryDao {

	@Override
	public List<BookHistory> getHistoryByPassID(int pasID) throws SomeThingWentWrongException, NoRecordFoundException {
		List<BookHistory> blist = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "SELECT * FROM bookinginfo b INNER JOIN passangerinfo p ON b.pasID = p.pasID "
					+ "INNER JOIN bus_info t ON b.busID = t.busID where B.pasID = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setInt(1, pasID);

			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new NoRecordFoundException("No Record Found ");
			}

			while (rs.next()) {
				BookHistory book = new BookHistoryIMPL();
				book.setBookID(rs.getInt("bookingID"));
				book.setBusID(rs.getInt("busID"));
				book.setFullname(rs.getString("fname") + " " + rs.getString("lname"));
				book.setJourneyTime(rs.getTimestamp("departureTime").toLocalDateTime().toString() + " "
						+ rs.getTimestamp("arrivalTime").toLocalDateTime().toString());
				book.setNoOfSeats(rs.getInt("noOfTickets"));
				book.setPassID(pasID);
				book.setRoute(rs.getString("source") + " to " + rs.getString("destination"));
				book.setTotalFare(rs.getInt("noOfTickets") * rs.getDouble("seatPrice"));
				blist.add(book);
			}
			return blist;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in getHistoryByPassID " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
	}

	@Override
	public List<BookHistory> getHistoryByPassIDForAdmin() throws SomeThingWentWrongException, NoRecordFoundException {
		List<BookHistory> blist = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "SELECT b.isCancel, p.pasID, b.busID, p.fname, p.lname, t.busName, t.source, t.destination, t.departureTime, t.arrivalTime, b.noOfTickets, \r\n"
					+ "(b.noOfTickets * t.seatPrice) TotalFare\r\n" + "FROM bookinginfo b\r\n"
					+ "INNER JOIN passangerinfo p ON b.pasID = p.pasID\r\n"
					+ "INNER JOIN bus_info t ON b.busID = t.busID\r\n" + "ORDER BY p.pasID;";
			PreparedStatement ps = con.prepareStatement(Insert);

			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new NoRecordFoundException("No Record Found ");
			}

			while (rs.next()) {
				BookHistory book = new BookHistoryIMPL();
				book.setBookID(rs.getInt("bookingID"));
				book.setStatus(rs.getInt("isCancel") == 1 ? "-" : "Canceled");
				book.setBusID(rs.getInt("busID"));
				book.setFullname(rs.getString("fname") + " " + rs.getString("lname"));
				book.setJourneyTime(rs.getTimestamp("departureTime").toLocalDateTime().toString() + " "
						+ rs.getTimestamp("arrivalTime").toLocalDateTime().toString());
				book.setNoOfSeats(rs.getInt("noOfTickets"));
				book.setPassID(rs.getInt("pasID"));
				book.setRoute(rs.getString("source") + " to " + rs.getString("destination"));
				book.setTotalFare(rs.getInt("noOfTickets") * rs.getDouble("seatPrice"));
				blist.add(book);
			}
			return blist;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in getHistoryByPassID " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
	}

}
