import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init() throws ServletException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=forLab8";
            String user = "sa";
            String password = "password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new ServletException("Unable to load JDBC driver.", e);
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to the database.", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Проверяем, есть ли пользователь с таким именем и паролем в базе данных
        boolean isAuthenticated = authenticate(username, password);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (isAuthenticated) {
            // Создаем сеанс и сохраняем имя пользователя
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Успешный ответ
            out.write("{\"status\": \"success\"}");
        } else {
            // Ответ об Ошибке
            out.write("{\"status\": \"error\", \"message\": \"Invalid username or password.\"}");
        }

        out.close();
    }

    private boolean authenticate(String username, String password) {
        String query = "SELECT password_hash FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String passwordHash = resultSet.getString("password_hash");
                    return BCrypt.checkpw(password, passwordHash);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}