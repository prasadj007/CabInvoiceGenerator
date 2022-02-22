package com.bridgelabz.InvoiceGenerate;

import java.util.Hashtable;

public class CabInvoiceGeneratorUC4 {

    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5.0;

    
    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;

        if(totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalAggregateFare = 0;
        for (Ride ride :rides) {
            totalAggregateFare += this.calculateFare(ride.distance,ride.time);
        }
        System.out.println(totalAggregateFare);
        return new InvoiceSummary(rides.length,totalAggregateFare);
    }

    public InvoiceSummary inVoiceService(Hashtable<Integer, Ride[]> listOfRides){
        Ride[] rides = listOfRides.get(1);
        InvoiceSummary inVoiceSummary = calculateFare(rides);
        return inVoiceSummary;
    }
}
