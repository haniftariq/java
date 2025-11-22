package com.day5;




interface Payable {
    void generatePayslip();
}

interface Bonus {
    void calculateBonus();
}

class Contractor implements Payable, Bonus {

    @Override
    public void generatePayslip() {
        System.out.println("Contractor salary will be calculated on a daily basis.");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Contractors are not eligible for bonus.");
    }
}

class FullTimeEmployee implements Payable, Bonus {

    @Override
    public void generatePayslip() {
        System.out.println("Full-time employee salary will be calculated on a monthly basis.");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Full-time employees get an annual performance bonus.");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Payable contractor = new Contractor();
        contractor.generatePayslip();
        ((Contractor) contractor).calculateBonus();

        Payable fte = new FullTimeEmployee();
        fte.generatePayslip();
        ((FullTimeEmployee) fte).calculateBonus();
    }
}