import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class firstServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
// Получаем параметры запроса
        String name = request.getParameter("name");
        String email = request.getParameter("email");

// Создаем экземпляр класса, который будет обрабатывать параметры запроса
        FormProcessor formProcessor = new FormProcessor();

// Обрабатываем параметры запроса и получаем результат
        String result = formProcessor.processForm(name, email);

// Отправляем ответ клиенту
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Form Submit Result:</h1>");
        out.print(result);
        out.println("</body></html>");
    }
}