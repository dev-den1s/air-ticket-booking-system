package booking_system.Data_Management.DAO;

import booking_system.Data_Management.entites.Client;

import java.sql.*;

public class ClientsDAO {
    private static final String url = "jdbc:sqlite:airlineBookingSystem.db";

    /**
     * Create table 'clients' if not exists
     */
    public static void createTableIfAbsent() {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS clients (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(100)," +
                    "surname VARCHAR(100)," +
                    "email VARCHAR(100)" +
                    ")");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Client selectById(int id) {
        Client client = null;
        String query = "SELECT * FROM clients WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    client = getClientFromResultSet(resultSet);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return client;
    }

    private static Client getClientFromResultSet(ResultSet resultSet) throws SQLException {
        int idd = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String surname = resultSet.getString(3);
        String email = resultSet.getString(4);

        return new Client(idd, name, surname, email);
    }

    public static void insertClient(Client client) {
        String query = "INSERT INTO clients (name,surname,email) VALUES(?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    client.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void deleteClient(int id) {
        String sql = "DELETE FROM clients WHERE id=?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
