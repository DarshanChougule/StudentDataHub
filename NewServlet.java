
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewServlet extends HttpServlet {

    public static boolean authentication(String username, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/darshan", "root", "");
        PreparedStatement st = con.prepareStatement("SELECT username, password FROM login WHERE username = ? AND password = ?");
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        return rs.next();  // return true if the user exists
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();

        // Check if username and password are not null
        if (name == null || pass == null || name.isEmpty() || pass.isEmpty()) {
            out.println("<html><body>");
            out.println("<h1>Username and Password cannot be empty!</h1>");
            out.println("</body></html>");
            return;
        }

        boolean authenticated = authentication(name, pass);

//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet NewServlet</title>");
//        out.println("</head>");
//        out.println("<body>");
        if (authenticated) {
//            out.println("<h1>Login Successful!</h1>");
            response.sendRedirect("decision.html");
        } else {
            response.sendRedirect("index.html");
        }
//        out.println("</body>");
//        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
