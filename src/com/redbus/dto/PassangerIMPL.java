package com.redbus.dto;

public class PassangerIMPL implements Passanger {

	private int passID;
	private String fname;
	private String username;
	private String password;
	private long mob_no;
	private double wallet;
	private String lname;
	private String address;
	private int isDelete;

	public PassangerIMPL(String fname, String username, String password, long mob_no, double wallet, String lname,
			String address) {
		this.fname = fname;
		this.username = username;
		this.password = password;
		this.mob_no = mob_no;
		this.wallet = wallet;
		this.lname = lname;
		this.address = address;
	}

	public PassangerIMPL() {
	}

	public int getPassID() {
		return passID;
	}

	public void setPassID(int passID) {
		this.passID = passID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMob_no() {
		return mob_no;
	}

	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
