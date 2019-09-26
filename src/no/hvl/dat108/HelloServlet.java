package no.hvl.dat108;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = StringEscapeUtils.escapeHtml4(request.getParameter("name"));
        String language = request.getHeader("accept-language").split(",")[0];
        System.out.println(request.getHeader("accept-language"));

        String greeting = chooseLanguage(language);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Title</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <p>" + greeting + " " + name + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    public String chooseLanguage(String language) {
        if (language.equals("no"))
            return "Hei";
        else if (language.equals("de"))
            return "Guten Tag";
        else
            return "Hello";
    }
}
