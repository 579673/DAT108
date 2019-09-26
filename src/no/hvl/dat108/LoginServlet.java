package no.hvl.dat108;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String referer = request.getHeader("referer");

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("   <meta charset=\"UTF-8\">");
        out.println("   <title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("        <fieldset>");
        out.println("            <legend>Login Result</legend>");
        out.println("            <p>Username: " + username + "</p>");
        out.println("            <p>Password: " + password + "</p>");
        out.println("            <p>Logged in from: " + referer + "</p>");
        out.println("        </fieldset>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
