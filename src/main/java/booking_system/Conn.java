package booking_system;

import booking_system.Data_Management.DAO.ClientsDAO;
import booking_system.Data_Management.DAO.CredentialsDAO;
import booking_system.Data_Management.entites.Client;
import booking_system.Data_Management.entites.Credentials;

import java.sql.*;
import java.util.Optional;

public class Conn {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:airlineBookingSystem.db")) {


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
