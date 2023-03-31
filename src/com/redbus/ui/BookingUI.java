package com.redbus.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.redbus.dao.BookingDao;
import com.redbus.dao.BookingDaoIMPL;
import com.redbus.dao.PassengerDao;
import com.redbus.dao.PassengerDaoIMPL;
import com.redbus.dto.Booking;
import com.redbus.dto.BookingIMPL;
import com.redbus.exception.SomeThingWentWrongException;

public class BookingUI {
	Scanner sc;
	BufferedReader br;
	PassengerDao pdao;
	BookingDao bdao;
	public BookingUI(Scanner sc) {
		this.sc = sc;
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.pdao = new PassengerDaoIMPL();
		this.bdao = new BookingDaoIMPL();
	}
	public void bookBusTicket() {
		Booking bookT = new BookingIMPL();
		System.out.println("BusID: ");
		bookT.setBusID(sc.nextInt());
		System.out.println("No Of Ticket: ");
		bookT.setNoOfTickete(sc.nextInt());
		bookT.setPassID(LoggedUser.passID);
		try {
			bdao.bookBus(bookT);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
