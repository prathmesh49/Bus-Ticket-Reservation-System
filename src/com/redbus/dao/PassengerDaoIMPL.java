package com.redbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.redbus.dto.Passanger;
import com.redbus.dto.PassangerIMPL;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;
import com.redbus.ui.LoggedUser;

public class PassengerDaoIMPL implements PassengerDao {

	/**
	 * Register passenger details
	 * 
	 * @param: Passanger
	 * @throws: SomeThingWentWrongException
	 */
	@Override
	public void addNewPassger(Passanger pas) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "INSERT INTO passangerinfo (fname, username, password, mobile_no, wallet, lname, address, isDelete)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setString(1, pas.getFname());
			ps.setString(2, pas.getUsername());
			ps.setString(3, pas.getPassword());
			ps.setLong(4, pas.getMob_no());
			ps.setDouble(5, pas.getWallet());
			ps.setString(6, pas.getLname());
			ps.setString(7, pas.getAddress());
			ps.setInt(8, 1);

			if (ps.executeUpdate() > 0) {
				System.out.println("Details added!");
			} else {
				System.out.println("Details cannot be added");
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in add New Passger " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

	/**
	 * SET the isDelete to 0 its mean false @throws; SomeThingWentWrongException
	 */
	@Override
	public void deletePass(int val) throws SomeThingWentWrongException, NoRecordFoundException {

		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "UPDATE passangerinfo SET isDelete = 0 WHERE pasID = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setInt(1, val);

			if (ps.executeUpdate() > 0) {
				System.out.println("Details added!");
			} else {
				System.out.println("Details cannot be added");
				throw new NoRecordFoundException("No Record found for this pass id");

			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in add New Passger " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
	}

	/**
	 * get the logged user details
	 * 
	 * @param: passenger ID
	 * @throws: SomeThingWentWrongException, NoRecordFoundException
	 */
	@Override
	public Passanger showPersonelDet(int val) throws SomeThingWentWrongException, NoRecordFoundException {
		Connection con = null;
		Passanger pass = new PassangerIMPL();
		try {
			con = DBUtility.connectToDB();
			String Select = "Select * from passangerinfo where pasID = ?";
			PreparedStatement ps = con.prepareStatement(Select);
			ps.setInt(1, val);

			ResultSet rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				throw new NoRecordFoundException("No Record found");

			}
			rs.next();
			pass.setAddress(rs.getString("address"));
			pass.setFname(rs.getString("fname"));
			pass.setLname(rs.getString("lname"));
			pass.setMob_no(rs.getLong("mobile_no"));
			pass.setPassID(rs.getInt("pasID"));
			pass.setUsername(rs.getString("username"));
			pass.setWallet(rs.getDouble("wallet"));

			return pass;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in showPersonelDet " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

	@Override
	public void updatePassengerDet(Passanger pas) throws SomeThingWentWrongException, NoRecordFoundException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "UPDATE passangerinfo SET fname = ?, username = ?, password = ?, mobile_no = ?, lname = ?, address = ? WHERE pasID = ?";

			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setString(1, pas.getFname());
			ps.setString(2, pas.getUsername());
			ps.setString(3, pas.getPassword());
			ps.setLong(4, pas.getMob_no());
			ps.setString(5, pas.getLname());
			ps.setString(6, pas.getAddress());
			ps.setInt(7, pas.getPassID());

			if (ps.executeUpdate() > 0) {
				System.out.println("Details Updated!");
			} else {
				System.out.println("Details cannot be added");
			}
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in update Passenger Det " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}

	}

	@Override
	public boolean passLogIn(String user, String pass) throws SomeThingWentWrongException {
		Connection con = null;
		try {
			con = DBUtility.connectToDB();
			String Insert = "Select username, password from passangerinfO where username = ?";
			PreparedStatement ps = con.prepareStatement(Insert);
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			String str = null;
			if (!rs.isBeforeFirst()) {
				return false;
			} else {
				while(rs.next()) {
					str = rs.getString("password");
					LoggedUser.passID = rs.getInt("pasID");
				}
			}
			if(str.equals(pass))
				return true;
			else 
				return false;
		} catch (SQLException e) {
			throw new SomeThingWentWrongException(" Error in pass LogIn " + e.getLocalizedMessage());
		} finally {
			try {
				DBUtility.close(con);
			} catch (SQLException e) {

				System.out.println(" Error in close connection " + e.getLocalizedMessage());
			}
		}
		
	}
	

}
