package com.redbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.redbus.dto.BusInfo;
import com.redbus.dto.BusInfoIMPL;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class BusDaoIMPL implements BusDao {

	/**
	 * adding new bus by admin
	 * 
	 * @param: BusInfo this class having all details of bus
	 * @throws: SomeThingWentWrongException
	 */
	@Override
	public void addNewBus(BusInfo bus) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "INSERT INTO bus_info (busName, source, destination, busType, departureTime, arrivalTime, totalSeats, status, seatPrice)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setString(1, bus.getBusname().toString());
			ps.setString(2, bus.getSource().toString());
			ps.setString(3, bus.getDestination().toString());
			ps.setString(4, bus.getBustype().toString());
			ps.setTimestamp(5, Timestamp.valueOf(bus.getDepartur_time()));
			ps.setTimestamp(6, Timestamp.valueOf(bus.getArrival_time()));
			ps.setInt(7, bus.getTotal_seat());
			ps.setBoolean(8, bus.isStatus());
			ps.setDouble(9, bus.getSeat_price());
			if (ps.executeUpdate() > 0) {
				System.out.println("Bus added!");
			} else {
				System.out.println("Bus cannot be added");
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in add new bus " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

	/**
	 * update the bus information by admin
	 * 
	 * @param: busname, bustype, totalseat (Bus_Info)
	 * @throws: SomeThingWentWrongException
	 *
	 */
	@Override
	public void updateBus(BusInfo bus, int bname) throws SomeThingWentWrongException, NoRecordFoundException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "UPDATE bus_info SET busName = ?, busType = ?, totalSeats = ? WHERE busid = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setString(1, bus.getbName());
			ps.setString(2, bus.getbType());
			ps.setInt(3, bus.getTotal_seat());
			ps.setInt(4, bname);
			if (ps.executeUpdate() > 0) {
				System.out.println("Bus Details Updated!");
			} else {
				throw new NoRecordFoundException(" No record Found for " + bname);
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException("Error in updateBus " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
	}

	/**
	 * all column values retrieve from the databases
	 * 
	 * @param: none
	 * @throws: SomeThingWentWrongException NoRecordFoundException
	 */
	@Override
	public List<BusInfo> getAllBuses() throws SomeThingWentWrongException, NoRecordFoundException {
		List<BusInfo> blist = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "SELECT * FROM bus_info where status = 1";
			PreparedStatement ps = con.prepareStatement(Insert);

			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new NoRecordFoundException("No Record Found ");
			}

			while (rs.next()) {
				BusInfo bus = new BusInfoIMPL();
				bus.setBusID(rs.getInt(1));
				bus.setbName(rs.getString(2));
				bus.setSource2(rs.getString(3));
				bus.setDestination2(rs.getString(4));
				bus.setbType(rs.getString(5));
				bus.setDepartur_time(rs.getTimestamp(6).toLocalDateTime());
				bus.setArrival_time(rs.getTimestamp(7).toLocalDateTime());
				bus.setTotal_seat(rs.getInt(8));
				bus.setStatus(rs.getBoolean(9));
				bus.setSeat_price(rs.getDouble(10));
				blist.add(bus);
			}
			return blist;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in getAllBuses " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

	/**
	 * delete the bus mean that status is going to 0 means false
	 * 
	 * @param: accept the bus id
	 * @throws: SomeThingWentWrongException, NoRecordFoundException
	 */
	@Override
	public void deleteBus(int bid) throws SomeThingWentWrongException, NoRecordFoundException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "UPDATE bus_info SET status = 0 WHERE busid = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setInt(1, bid);

			if (ps.executeUpdate() > 0) {
				System.out.println("Bus Deleted!");
			} else {
				throw new NoRecordFoundException("No record Found for this " + bid);
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException("Error in deleteBus " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

}
