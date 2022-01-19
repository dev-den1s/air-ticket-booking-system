package booking_system.Data_Management.DAO;

import booking_system.Data_Management.entites.Credentials;

import java.sql.*;
import java.util.Optional;

public class CredentialsDAO {
    private static final String url = "jdbc:sqlite:airlineBookingSystem.db";

    /**
     * Create table 'credentials' if not exists
     */
    public static void createTableIfAbsent() {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS credentials (" +
                    "client_id INTEGER REFERENCES clients (id)," +
                    "login VARCHAR(30) PRIMARY KEY," +
                    "password VARCHAR(30)" +
                    ")");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertCredentials(int clien_id, String login, char[] password) {
        String query = "INSERT INTO credentials (client_id,login,password) VALUES(?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {

            preparedStatement.setInt(1, clien_id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, new String(password));
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static Optional<Integer> getClientId(String login, char[] password) {
        Integer client_id = null;
        String query = "SELECT client_id FROM credentials WHERE login LIKE ? AND password LIKE ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, new String(password));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    client_id = resultSet.getInt(1);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.ofNullable(client_id);
    }

    private static Credentials getCredentialsFromResultSet(ResultSet resultSet) throws SQLException {
        int client_id = resultSet.getInt(1);
        String login = resultSet.getString(2);
        char[] password = resultSet.getString(3).toCharArray();

        return new Credentials(client_id, login, password);
    }

    public static void updatePassword(int clien_id, char[] password) {
        String sql = "UPDATE credentials SET password=?  WHERE client_id=?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, new String(password));
            preparedStatement.setInt(2, clien_id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateLogin(int clien_id, String login) {
        String sql = "UPDATE credentials SET  login=?  WHERE client_id=?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, clien_id);


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
