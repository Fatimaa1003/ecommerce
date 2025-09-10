import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection con = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO cart_items (user_id, product_id, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, userId);
                pst.setInt(2, productId);
                pst.setInt(3, quantity);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }

        response.sendRedirect("cart.jsp");
    }
}
