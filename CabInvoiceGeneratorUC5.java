package com.bridgelabz.InvoiceGenerate;

import java.util.Hashtable;
import java.util.Scanner;
public class CabInvoiceGeneratorUC5 {


	Scanner scanner = new Scanner(System.in);
	public double calculateFare(double distance, int time) {
		int costPerMinute = 0;
		double minimumCostPerKM = 0;
		double minimumFare = 0;

		System.out.println("\nPress 1 - Normal Rides\nPress 2 - Premium Rides");
		int choice = scanner.nextInt();

		if (choice == 1) {

			costPerMinute = 1;
			minimumCostPerKM = 10;
			minimumFare = 5;

		} else if (choice == 2) {

			costPerMinute = 2;
			minimumCostPerKM = 15;
			minimumFare = 20;

		} else {

			System.out.println("Invalid Input !!! ");

		}

		double totalFare = distance * minimumCostPerKM + time * costPerMinute;

		if (totalFare < minimumFare)
			return minimumFare;

		return totalFare;

	}

	// Purpose : To calculate fare for multiple rides

	public InvoiceSummary calculateFare(Ride[] rides) {

		double totalAggregateFare = 0;
		for (Ride ride : rides) {

			totalAggregateFare += this.calculateFare(ride.distance, ride.time);

		}

		System.out.println(totalAggregateFare);
		return new InvoiceSummary(rides.length, totalAggregateFare);

	}


	public InvoiceSummary inVoiceService(Hashtable<Integer, Ride[]> listOfRides) {

		Ride[] rides = listOfRides.get(1);
		InvoiceSummary inVoiceSummary = calculateFare(rides);
		return inVoiceSummary;
	}
}

