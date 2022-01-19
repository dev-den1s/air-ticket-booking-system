package booking_system.serlvets;

import booking_system.Data_Management.DAO.ClientsDAO;
import booking_system.Data_Management.DAO.CredentialsDAO;
import booking_system.Data_Management.entites.Client;
import booking_system.Data_Management.repository.IAirlineBookingSystemRepository;
import booking_system.Data_Management.repository.SqlAirlineBookingSystemRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String text = "Please enter your username and password to log in.";
        req.setAttribute("text", text);
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        char[] password = req.getParameter("password").toCharArray();

        IAirlineBookingSystemRepository repository = new SqlAirlineBookingSystemRepository();
        Optional<Client> client = repository.logIn(login, password);

        if (client.isPresent()) {
            req.setAttribute("client", client.get());
            req.getRequestDispatcher("/WEB-INF/views/loggedin.jsp").forward(req, resp);
        } else {
            String text = "Invalid username or password.";
            req.setAttribute("text", text);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }

    }
}
