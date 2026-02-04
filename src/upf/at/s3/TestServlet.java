package upf.at.s3;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // Requirement: Use an HTTP Header
        String userAgent = request.getHeader("User-Agent"); 
        
        // Get the data from the HTML Form
        String name = request.getParameter("username"); 
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Hello, " + (name != null ? name : "Guest") + "!</h1>");
        out.println("<p>Your browser is: " + userAgent + "</p>");
        out.println("</body></html>");
    }
}