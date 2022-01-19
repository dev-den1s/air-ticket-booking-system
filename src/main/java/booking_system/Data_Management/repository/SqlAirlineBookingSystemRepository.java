package booking_system.Data_Management.repository;

import booking_system.Data_Management.DAO.ClientsDAO;
import booking_system.Data_Management.DAO.CredentialsDAO;
import booking_system.Data_Management.entites.Client;
import booking_system.Data_Management.entites.Credentials;

import java.util.Optional;

public class SqlAirlineBookingSystemRepository implements IAirlineBookingSystemRepository {
    @Override
    public Optional<Client> logIn(String login, char[] password) {
        Client client = null;
        Optional<Integer> clientId = CredentialsDAO.getClientId(login, password);
        if (clientId.isPresent()) {
            client = ClientsDAO.selectById(clientId.get());
        }
        return Optional.ofNullable(client);
    }
}
