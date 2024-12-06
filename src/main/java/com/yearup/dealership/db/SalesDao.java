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
                     "INSERT INTO sales_contracts (contract_id, vin, sale_date, price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, salesContract.getContractId());
            preparedStatement.setString(2, salesContract.getVin());
            preparedStatement.setDate(3, Date.valueOf(salesContract.getSaleDate()));
            preparedStatement.setDouble(4, salesContract.getPrice());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
