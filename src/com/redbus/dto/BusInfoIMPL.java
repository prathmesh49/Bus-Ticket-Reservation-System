package com.redbus.dto;

import java.time.LocalDateTime;

public class BusInfoIMPL implements BusInfo{

	private int busID;
	private BusName busname;
	private String bName;
	private Source source;
	private String source2;
	private Destination destination;
	private String destination2;
	private BusType bustype;
	private String bustype2;
	private String bType;
	private LocalDateTime departur_time;
	private LocalDateTime arrival_time;
	private int total_seat;
	private boolean status;
	private double seat_price;

	public BusInfoIMPL(int busID, BusName busname, Source source, Destination destination, BusType bustype,
			LocalDateTime departur_time, LocalDateTime arrival_time, int total_seat, boolean status,
			double seat_price) {
		super();
		this.busID = busID;
		this.busname = busname;
		this.source = source;
		this.destination = destination;
		this.bustype = bustype;
		this.departur_time = departur_time;
		this.arrival_time = arrival_time;
		this.total_seat = total_seat;
		this.status = status;
		this.seat_price = seat_price;
	}

	public BusInfoIMPL() {
		super();
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}

	public BusName getBusname() {
		return busname;
	}

	public void setBusname(BusName busname) {
		this.busname = busname;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public BusType getBustype() {
		return bustype;
	}

	public void setBustype(BusType bustype) {
		this.bustype = bustype;
	}

	public LocalDateTime getDepartur_time() {
		return departur_time;
	}

	public void setDepartur_time(LocalDateTime departur_time) {
		this.departur_time = departur_time;
	}

	public LocalDateTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalDateTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getSeat_price() {
		return seat_price;
	}

	public void setSeat_price(double seat_price) {
		this.seat_price = seat_price;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getSource2() {
		return source2;
	}

	public void setSource2(String source2) {
		this.source2 = source2;
	}

	public String getDestination2() {
		return destination2;
	}

	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}

	public String getBustype2() {
		return bustype2;
	}

	public void setBustype2(String bustype2) {
		this.bustype2 = bustype2;
	}

}
