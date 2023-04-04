package com.redbus.dao;

import java.util.List;

import com.redbus.dto.BookHistory;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public interface BookHistoryDao {
	public List<BookHistory> getHistoryByPassID(int pasID) throws SomeThingWentWrongException, NoRecordFoundException;
	
	public List<BookHistory> getHistoryByPassIDForAdmin() throws SomeThingWentWrongException, NoRecordFoundException; 
}
