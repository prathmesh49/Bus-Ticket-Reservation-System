package com.redbus.main;

import java.util.Scanner;

import com.redbus.ui.AdminUI;
import com.redbus.ui.PassengerUI;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminUI aui = new AdminUI(sc);
		PassengerUI pui = new PassengerUI(sc);
		System.out.println("+----------------------------+\n"
						  +"| Welcome                    |\n"
						  +"| To                         |\n"
						  +"| RedBus Booking             |\n"
						  +"+----------------------------+\n");
		
		int choice =0;
		do {
			System.out.println("+----------------------------+\n"
							  +"| 1. For Administrator login |\n"
							  +"| 2. For Passanger           |\n"
							  +"| 0. Exit                    |\n"
							  +"+----------------------------+\n");
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Invalid Input, try again!");
			}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				aui.mainOpp();
				break;
			case 2:
				pui.main();
				break;

			default:
				if(choice !=0)
					System.out.println("Invalid Input, try again!");
				else
					System.out.println("Exited!");
				break;
			}
		}while(choice != 0);
		sc.close();
	}

}
