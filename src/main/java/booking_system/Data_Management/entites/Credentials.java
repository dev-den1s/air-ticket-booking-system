package booking_system.Data_Management.entites;

public class Credentials {
    private int client_id;
    private String login;
    private char[] password;

    public Credentials(int client_id, String login, char[] password) {
        this.client_id = client_id;
        this.login = login;
        this.password = password;
    }


    public int getClient_id() {
        return client_id;
    }

    public char[] getPassword() {
        return password;
    }
}
