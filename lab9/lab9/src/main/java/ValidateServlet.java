import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String macAddress = request.getParameter("macAddress");

        boolean isValid = validateMacAddress(macAddress);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>MAC Address Validation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>MAC Address Validation</h1>");

        if (isValid) {
            out.println("<p>The MAC Address <strong>" + macAddress + "</strong> is valid.</p>");
        } else {
            out.println("<p>The MAC Address <strong>" + macAddress + "</strong> is invalid.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    private boolean validateMacAddress(String macAddress) {
        String pattern = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(macAddress);
        return m.matches();
    }
}
