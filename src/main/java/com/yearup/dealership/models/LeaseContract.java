package com.yearup.dealership.models;

import java.time.LocalDate;

public class LeaseContract {
    private int contractId;
    private final String vin;
    private final LocalDate leaseStart;
    private final LocalDate leaseEnd;
    private final double monthlyPayment;

    public LeaseContract(String vin, LocalDate leaseStart, LocalDate leaseEnd, double monthlyPayment) {
        this.vin = vin;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
        this.monthlyPayment = monthlyPayment;
    }

    public LeaseContract(int contractId, String vin, LocalDate leaseStart, LocalDate leaseEnd, double monthlyPayment) {
        this.contractId = contractId;
        this.vin = vin;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
        this.monthlyPayment = monthlyPayment;
    }

    public int getContractId() {
        return contractId;
    }

    public String getVin() {
        return vin;
    }

    public LocalDate getLeaseStart() {
        return leaseStart;
    }

    public LocalDate getLeaseEnd() {
        return leaseEnd;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }


    @Override
    public String toString() {
        return "LeaseContract{" +
                "contractId=" + contractId +
                ", vin='" + vin + '\'' +
                ", leaseStart=" + leaseStart +
                ", leaseEnd=" + leaseEnd +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}