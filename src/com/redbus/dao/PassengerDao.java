package com.redbus.dao;

import com.redbus.dto.Passanger;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public interface PassengerDao {
	public void addNewPassger(Passanger pas) throws SomeThingWentWrongException;
	public void deletePass(int val) throws SomeThingWentWrongException,NoRecordFoundException;
	public Passanger showPersonelDet(int val) throws SomeThingWentWrongException, NoRecordFoundException;
	public void updatePassengerDet(Passanger pas) throws SomeThingWentWrongException, NoRecordFoundException;
	public boolean passLogIn(String user, String pass) throws SomeThingWentWrongException;
}
