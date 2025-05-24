/*
 6c. Build a servlet program to check the given number is prime number or not using HTML with step
by step procedure.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primecheck")
public class PrimeCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // HTML response
            out.println("<html>");
            out.println("<head><title>Prime Number Checker</title></head>");
            out.println("<body style='font-family: Arial; margin: 40px;'>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>The number <b>" + number + "</b> is " +
                    (isPrime ? "<span style='color:green;'>a Prime Number</span>"
                             : "<span style='color:red;'>not a Prime Number</span>") +
                    ".</p>");
            out.println("<a href='primecheck'>Check another number</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid integer number.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Display the input form
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Prime Number Checker</title></head>");
        out.println("<body style='font-family: Arial; margin: 40px;'>");
        out.println("<h2>Prime Number Checker</h2>");
        out.println("<form action='primecheck' method='post'>");
        out.println("Enter a number: <input type='text' name='number' required>");
        out.println("<input type='submit' value='Check'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body style='font-family: Arial; color: red; margin: 40px;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='primecheck'>Try Again</a>");
        out.println("</body></html>");
    }
}
