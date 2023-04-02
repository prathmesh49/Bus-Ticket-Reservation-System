package com.redbus.main;

import java.util.Scanner;

import com.redbus.dao.PassengerDao;
import com.redbus.dao.PassengerDaoIMPL;
import com.redbus.exception.SomeThingWentWrongException;
import com.redbus.ui.AdminUI;
import com.redbus.ui.PassengerUI;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminUI aui = new AdminUI(sc);
		
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
				if(adminlog(sc))
					aui.mainOpp();
				else
					System.out.println("Wrong Credential!");
				break;
			case 2:
				passMain(sc);
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
	static boolean adminlog(Scanner sc) {
		System.out.println("Enter Username: ");
		String s1 = sc.next();
		System.out.println("Enter Password: ");
		String s2 = sc.next();
		return s1.equals("admin") && s2.equals("admin")? true: false;
	}
	static boolean passLogin(Scanner sc) {
		System.out.println("Enter Username: ");
		String s1 = sc.next();
		System.out.println("Enter Password: ");
		String s2 = sc.next();
		PassengerDao pdao = new PassengerDaoIMPL();
		boolean ans = false;
		try {
			ans = pdao.passLogIn(s1, s2);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
	static void passMain(Scanner sc) {
		PassengerUI pui = new PassengerUI(sc);
		int choice =0;
		do {
			System.out.println("+----------------------------+\n"
							  +"| 1. Sign In                 |\n"
							  +"| 2. Sign Up                 |\n"
							  +"| 0. Exit                    |\n"
							  +"+----------------------------+\n");
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Invalid Input, try again!");
			}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if(passLogin(sc)) {
					System.out.println("Sign In Successfully!");
				    pui.main();
				}
				else
					System.out.println("Wrong Credential!");
				break;
			case 2:
				pui.registerNewPas();
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

}
