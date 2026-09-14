/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab04_francesco;

/**
 *
 * @author 2548213
 */


public class Reimbursment {

    /**
     * Calculates the reimbursement of a given trip.
     * @param days The length of the trip.
     * @param milesDriven The miles driven in a car.
     * @param privateCar If a private car was used.
     * @param parkingFees If a private car was used, how much were the parking fees?
     * @param taxiCharges If a private car wasn't used, how much was the taxi charges?
     * @param lodgingFees The amount spent on lodging.
     * @return 
     */
    public static double calcReimbursement(int days, double milesDriven, boolean privateCar, double parkingFees, double taxiCharges, double lodgingFees) {
        double Reimbursement = 0.00;
        int mealGift = 37;
        
        if (privateCar == true) {
            Reimbursement += 0.27*milesDriven;
            Reimbursement += Math.max(10, parkingFees*0.25)*days;
        } else {
            Reimbursement += Math.max(20, taxiCharges*0.5)*days;
        }
        
        Reimbursement += Math.max(95, lodgingFees*0.15)*days/2;
        
        return Reimbursement + mealGift;
    }
    
}
