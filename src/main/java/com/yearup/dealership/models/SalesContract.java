package com.yearup.dealership.models;

import java.time.LocalDate;

public class SalesContract {
    private int contractId;
    private String vin;
    private LocalDate saleDate;
    private double totalCost;
    private String name;
    private String email;
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean financed;
    private double monthlyPayment;

    public SalesContract(String vin, LocalDate saleDate, double totalCost) {
        this.vin = vin;
        this.saleDate = saleDate;
        this.totalCost = totalCost;
        this.name = "TESTING_NAME";
        this.email = "TESTING_EMAIL";
        this.salesTax = 0;
        this.recordingFee = 0;
        this.processingFee = 0;
        this.financed = false;
        this.monthlyPayment = 0;
    }

    public SalesContract(int contractId, String vin, LocalDate saleDate, double totalCost, String name, String email, double salesTax, double recordingFee, double processingFee, boolean financed, Double monthlyPayment) {
        this.contractId = contractId;
        this.vin = vin;
        this.saleDate = saleDate;
        this.totalCost = totalCost;
        this.name = name;
        this.email = email;
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financed = financed;
        this.monthlyPayment = monthlyPayment;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getSalesTax(){
        return salesTax;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "contractId=" + contractId +
                ", vin='" + vin + '\'' +
                ", saleDate=" + saleDate +
                ", totalCost" + totalCost +
                '}';
    }
}