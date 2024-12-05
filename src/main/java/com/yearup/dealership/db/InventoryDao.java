package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InventoryDao {
    private final DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO inventory (dealership_id, vin) VALUES (?,?)")) {
            preparedStatement.setInt(1, dealershipId);
            preparedStatement.setString(2, vin);


            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeVehicleFromInventory(String vin) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM inventory WHERE vin = ?")) {
            preparedStatement.setString(1, vin);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
