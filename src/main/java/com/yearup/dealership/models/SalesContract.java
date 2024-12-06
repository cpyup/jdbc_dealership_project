package com.yearup.dealership.models;

import java.time.LocalDate;

public class SalesContract {
    private int contractId;
    private final String vin;
    private final LocalDate saleDate;
    private final double price;

    public SalesContract(String vin, LocalDate saleDate, double price) {
        this.vin = vin;
        this.saleDate = saleDate;
        this.price = price;

    }

    public SalesContract(int contractId, String vin, LocalDate saleDate, double price) {
        this.contractId = contractId;
        this.vin = vin;
        this.saleDate = saleDate;
        this.price = price;
    }

    public int getContractId() {
        return contractId;
    }

    public String getVin() {
        return vin;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "SalesContract{" +
                "contractId=" + contractId +
                ", vin='" + vin + '\'' +
                ", saleDate=" + saleDate +
                ", totalCost" + price +
                '}';
    }
}