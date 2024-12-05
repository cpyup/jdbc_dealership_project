package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class SalesDao {
    private final DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO sales_contracts (id, contract_date, name, email, vin, sales_tax, recording_fee, processing_fee, total_cost, financed, monthly_payment) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, salesContract.getContractId());
            preparedStatement.setDate(2, Date.valueOf(salesContract.getSaleDate()));
            preparedStatement.setString(3, salesContract.getName());
            preparedStatement.setString(4, salesContract.getEmail());
            preparedStatement.setString(5, salesContract.getVin());
            preparedStatement.setDouble(6, salesContract.getSalesTax());
            preparedStatement.setDouble(7, salesContract.getRecordingFee());
            preparedStatement.setDouble(8,salesContract.getProcessingFee());
            preparedStatement.setDouble(9,salesContract.getTotalCost());
            preparedStatement.setBoolean(10, salesContract.isFinanced());
            preparedStatement.setDouble(11, salesContract.getMonthlyPayment());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
