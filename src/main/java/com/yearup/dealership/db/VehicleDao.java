package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        // TODO: Implement the logic to add a vehicle
    }

    public void removeVehicle(String VIN) {
        // TODO: Implement the logic to remove a vehicle
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE price BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setDouble(1, minPrice);
            statement.setDouble(2,maxPrice);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;

    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE make LIKE ? AND model LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setString(1, make);
            statement.setString(2, model);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE year BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setInt(1, minYear);
            statement.setInt(2,maxYear);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE color = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setString(1, color);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE odometer BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setInt(1, minMileage);
            statement.setInt(2,maxMileage);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByType(String type) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehicleQuery = "SELECT * FROM dealership.vehicles WHERE type = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(vehicleQuery)) {
            statement.setString(1, type);

            try (ResultSet results = statement.executeQuery()) {
                while(results.next()){
                    vehicles.add(createVehicleFromResultSet(results));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("type"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
