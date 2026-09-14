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
    int days = 0;
    double airfareFees = 0;
    double rentalFees = 0;
    double milesDriven = 0;
    boolean privateCar = false;
    double parkingFees = 0;
    double taxiCharges = 0;
    double conferenceFees = 0;
    double lodgingFees = 0;

    public Reimbursment(int days, double airfareFees, double rentalFees, double milesDriven, boolean privateCar, double parkingFees, double taxiCharges, double conferenceFees, double lodgingFees) {
        this.days = days;
        this.airfareFees = airfareFees;
        this.rentalFees = rentalFees;
        this.milesDriven = milesDriven;
        this.privateCar = privateCar;
        this.parkingFees = parkingFees;
        this.taxiCharges = taxiCharges;
        this.conferenceFees = conferenceFees;
        this.lodgingFees = lodgingFees;
        
        if (privateCar == true) {
            this.parkingFees = 0;
        } else {
            this.rentalFees = 0;
            this.taxiCharges = 0;
        }
        
    }

    
  

    
    
    
}
