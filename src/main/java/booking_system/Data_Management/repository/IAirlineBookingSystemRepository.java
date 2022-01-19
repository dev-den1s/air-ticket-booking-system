package booking_system.Data_Management.repository;

import booking_system.Data_Management.entites.Client;

import java.util.Optional;

public interface IAirlineBookingSystemRepository {
    /**
     * Method checks if the user is logged into the system.
     * @param login
     * @param password
     * @return Optional<Client>
     */
    Optional<Client> logIn(String login, char[] password);
}
