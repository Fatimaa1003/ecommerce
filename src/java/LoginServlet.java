import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection con = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    // Successful login
                    response.sendRedirect("welcome.jsp");
                } else {
                    // Login failed
                    response.sendRedirect("login.jsp");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
