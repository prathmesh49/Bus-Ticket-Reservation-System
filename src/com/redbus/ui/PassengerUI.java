package com.redbus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.redbus.dao.BookHistoryDao;
import com.redbus.dao.BookHistoryDaoIMPL;
import com.redbus.dao.BusDao;
import com.redbus.dao.BusDaoIMPL;
import com.redbus.dao.PassengerDao;
import com.redbus.dao.PassengerDaoIMPL;
import com.redbus.dto.BookHistory;
import com.redbus.dto.BusInfo;
import com.redbus.dto.Passanger;
import com.redbus.dto.PassangerIMPL;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class PassengerUI {
	Scanner sc;
	BufferedReader br;
	PassengerDao pdao;
	List<BusInfo> showBusList ;
	BusDao bdao ;
	BookHistoryDao bhistory;

	public PassengerUI(Scanner sc) {
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.sc = sc ;
		this.pdao = new PassengerDaoIMPL();
		this.showBusList = new ArrayList<>();
		this.bdao = new BusDaoIMPL();
		this.bhistory = new BookHistoryDaoIMPL();
	}

	public void main() {
		BookingUI bui = new BookingUI(sc);
		System.out.println("+----------------------------+\n"
						  +"| Welcome                    |\n"
						  +"| To                         |\n"
						  +"| RedBus Booking             |\n"
						  +"+----------------------------+\n");
		int choice =0;
		do {
			System.out.println("+----------------------------+\n"
							  +"| 1. Show buses              |\n"
							  +"| 2. Book Ticket             |\n"
							  +"| 3. Booking Hstory          |\n"
							  +"| 4. See personel Details    |\n"
							  +"| 5. Delete My account       |\n"
							  +"| 0. Log Out!                |\n"
							  +"+----------------------------+\n");
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Invalid Input, try again!");
			}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				showAllDetails();
				break;
			case 2:
				bui.bookBusTicket();
				break;
			case 3:
				seeBookingHistory();
				break;
			case 4:
				seePersonelDet();
				break;
			case 5:
				deleteMyAcc();
				choice =0;
				break;

			default:
				if(choice !=0)
					System.out.println("Invalid Input, try again!");
				else
					System.out.println("Exited!");
				break;
			}
		}while(choice != 0);
	}
	public void showAllDetails() {
		try {
			showBusList = bdao.getAllBuses();
			System.out.printf("%-5s %-10s %-15s %-15s %-20s %-19s %-19s %-5s %-20s \n","BusID","BName","Start Journey","End journey","Bus Type","Departure","Arrival Time","Seats","Tickit Price");
			showBusList.forEach(s -> System.out.printf("%-5d %-10s %-15s %-15s %-20s %-19s %-19s %-5d %-20f \n",s.getBusID(),s.getbName(),s.getSource2(),s.getDestination2(),s.getbType(),s.getDepartur_time().toString(),s.getArrival_time().toString(),s.getTotal_seat(),s.getSeat_price()));
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	public void registerNewPas() {
		Passanger pas = new PassangerIMPL();
		try {
			System.out.println("First Name: ");
			pas.setFname(sc.next());
			System.out.println("Last Name: ");
			pas.setLname(sc.next());
			System.out.println("Username: ");
			pas.setUsername(sc.next());
			System.out.println("Password: ");
			pas.setPassword(sc.next());
			System.out.println("Mobile No: ");
			pas.setMob_no(sc.nextLong());
			System.out.println("Address: ");
			try {
				pas.setAddress(br.readLine());
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
			System.out.println("Add Amount to Wallet: ");
			pas.setWallet(sc.nextDouble());
			pas.setIsDelete(1);
		} catch (Exception e) {
			System.out.println("Invalid Input, try again! ");
		}
		try {
			pdao.addNewPassger(pas);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	public void deleteMyAcc() {
		try {
			pdao.deletePass(LoggedUser.passID);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	public void seePersonelDet() {
		try {
			Passanger pass = pdao.showPersonelDet(LoggedUser.passID);
			System.out.println("Name : " + pass.getFname()+" "+pass.getLname());
			System.out.println("Address : "+ pass.getAddress());
			System.out.println("Username : "+pass.getUsername());
			System.out.println("Mobile No : "+ pass.getMob_no());
			System.out.println("Wallet Balance : "+pass.getWallet());
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	public void seeBookingHistory() {
		List<BookHistory> bhlist = new ArrayList<>();
		try {
			bhlist = bhistory.getHistoryByPassID(LoggedUser.passID);
			System.out.printf("%-5s %-15s %-30s %-40s %-8s %-10s \n","BusID","Full Name","Route",
					"Journey Date & Time","Tickets","Amount");
			bhlist.forEach(s -> System.out.printf("%-5d %-15s %-30s %-40s %-8d %-10f \n",s.getBusID(),s.getFullname(),
					s.getRoute(),s.getJourneyTime(),s.getNoOfSeats(),s.getTotalFare()));
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
