package booking_system.Data_Management.entites;

import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String surname;
    private String email;

    public Client(String name, String surname, String email) {
        this.id = -1;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Client(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

}
