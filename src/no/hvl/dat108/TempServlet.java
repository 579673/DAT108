package no.hvl.dat108;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TempServlet")
public class TempServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("value");
        String unit = request.getParameter("unit");
        PrintWriter out = response.getWriter();

        if (inputIsValid(value, unit)) {
            double val = Double.parseDouble(value);
            String result = convertAndFormat(val, unit);
            showResultPage(result, out);
        }
        else {
            showErrorPage(out);
        }
    }

    private String convertAndFormat(double val, String unit) {
        String result;
        if (unit.equals("C")) {
            double fval = val * 1.8 + 32;
            result = String.format("%1$.1f &deg;C = %2$.1f &deg;F", val, fval);
        } else {
            double cval = (val - 32) / 1.8;
            result = String.format("%1$.1f &deg;F = %2$.1f &deg;C", val, cval);
        }
        return result;
    }

    private boolean inputIsValid(String value, String unit) {
        double val;
        try {
            val = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        if (unit == null || unit.equals("")) {
            return false;
        }
        if ((unit.equals("C") && val < -275.15) || (unit.equals("F") && val < -459.67)) {
            return false;
        }
        return true;
    }

    private void showResultPage(String result, PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Temperature Converter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Temperature Conversion Result</h1><br>");
        out.println("<p>" + result + "</p>");
        out.println("<a href=\"temp.html\">Return</a>");
        out.println("</body>");
        out.println("</html>");
    }

    private void showErrorPage(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Temperature Converter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Input Error</h1><br>");
        out.println("<font color=\"red\">Invalid input</font><br>");
        out.println("<a href=\"temp.html\">Return</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
