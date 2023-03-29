package com.redbus.dto;

import java.time.LocalDateTime;

public interface BusInfo {
	public int getBusID();

	public void setBusID(int busID);

	public BusName getBusname();

	public void setBusname(BusName busname);

	public Source getSource();

	public void setSource(Source source);

	public Destination getDestination();

	public void setDestination(Destination destination);

	public BusType getBustype();

	public void setBustype(BusType bustype);

	public LocalDateTime getDepartur_time();

	public void setDepartur_time(LocalDateTime departur_time);

	public LocalDateTime getArrival_time();

	public void setArrival_time(LocalDateTime arrival_time);

	public int getTotal_seat();

	public void setTotal_seat(int total_seat);

	public boolean isStatus();

	public void setStatus(boolean status);

	public double getSeat_price();

	public void setSeat_price(double seat_price);

	public String getbName();

	public void setbName(String bName);

	public String getbType();

	public void setbType(String bType);

	public String getSource2();

	public void setSource2(String source2);

	public String getDestination2();

	public void setDestination2(String destination2);

	public String getBustype2();

	public void setBustype2(String bustype2);
}
