package com.redbus.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.redbus.dao.BookHistoryDao;
import com.redbus.dao.BookHistoryDaoIMPL;
import com.redbus.dao.BookingDao;
import com.redbus.dao.BookingDaoIMPL;
import com.redbus.dao.PassengerDao;
import com.redbus.dao.PassengerDaoIMPL;
import com.redbus.dto.BookHistory;
import com.redbus.dto.Booking;
import com.redbus.dto.BookingIMPL;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class BookingUI {
	Scanner sc ;
	BufferedReader br ;
	PassengerDao pdao ;
	BookingDao bdao ;
	BookHistoryDao bhistory ;
	public BookingUI(Scanner sc) {
		this.sc = sc;
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.pdao = new PassengerDaoIMPL();
		this.bdao = new BookingDaoIMPL();
		this.bhistory = new BookHistoryDaoIMPL();
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
	
	public void seeBookingOption() {
		int choice =0;
		do {
			System.out.println("+----------------------------+\n"
							  +"| 1. See all Booking History |\n"
//							  +"| 2. By Date                 |\n"
//							  +"| 3. By Bus Name             |\n"
//							  +"| 4. By Mobile Number        |\n"
							  +"| 0. Exit                    |\n"
							  +"+----------------------------+\n");
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Invalid Input, try again!");
			}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				seeAllBookHistory();
				break;
			case 0:
				System.out.println("Exited!");
				choice = 0;
				break;
			default:
				System.out.println("Invalid Input, try again!");
				break;
			}
		}while(choice != 0);
	}
	public void seeAllBookHistory() {
		List<BookHistory> bhlist = new ArrayList<>();
		try {
			bhlist = bhistory.getHistoryByPassID(LoggedUser.passID);
			System.out.printf("%-5s %-9s %-5s %-15s %-30s %-40s %-8s %-10s \n","sr no","Status","BusID","Full Name","Route",
					"Journey Date & Time","Tickets","Amount");
			int i =1;
			for(BookHistory s : bhlist)
			 System.out.printf("%-5d %-8s %-5d %-15s %-30s %-40s %-8d %-10f \n",(i++),s.getStatus(),s.getBusID(),s.getFullname(),
					s.getRoute(),s.getJourneyTime(),s.getNoOfSeats(),s.getTotalFare());
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
