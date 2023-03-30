package com.redbus.dao;

import java.util.List;

import com.redbus.dto.BusInfo;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public interface BusDao {
	public void addNewBus(BusInfo bus) throws SomeThingWentWrongException;

	public void updateBus(BusInfo bus, String bname) throws SomeThingWentWrongException, NoRecordFoundException;
	
	public List<BusInfo> getAllBuses() throws SomeThingWentWrongException, NoRecordFoundException;
	
	public void deleteBus(int bid) throws SomeThingWentWrongException, NoRecordFoundException;
	
}
