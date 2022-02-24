package com.bridgelabz.InvoiceGenerate;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator inVoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        inVoiceGenerator = new CabInvoiceGenerator();
    }

   
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 4.0;
        int time = 10;
        double totalFare = inVoiceGenerator.calculateFare(distance, time);

        Assert.assertEquals(50.0,totalFare,0.0);
    }

   
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 2;
        double totalFare = inVoiceGenerator.calculateFare(distance, time);

        Assert.assertEquals(5.0,totalFare,0.0);
    }
    
    @Test
    public void givenMultipleRides_ShouldReturnTotalAggregate() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = inVoiceGenerator.calculateFare(rides);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);

        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}