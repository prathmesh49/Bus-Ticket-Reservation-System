package com.redbus.dto;

public class PassangerIMPL implements Passanger {

	private int passID;
	private String name;
	private String username;
	private String password;
	private int mob_no;
	private double wallet;

	public PassangerIMPL(int passID, String name, String username, String password, int mob_no, double wallet) {
		super();
		this.passID = passID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.mob_no = mob_no;
		this.wallet = wallet;
	}

	public PassangerIMPL() {
		super();
	}

	public int getPassID() {
		return passID;
	}

	public void setPassID(int passID) {
		this.passID = passID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getMob_no() {
		return mob_no;
	}

	public void setMob_no(int mob_no) {
		this.mob_no = mob_no;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

}
