import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ControllerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("x") == null || request.getParameter("y") == null ||
                request.getParameter("r") == null ) {
        } else {
            getServletContext().getNamedDispatcher("AreaChecker").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public String getServletInfo() {
        return "ControllerServlet - определяет тип запроса, и, в зависимости от того, содержит ли запрос информацию " +
                "о координатах точки и радиусе, делегирует его обработку стартовой jsp-странице или AreaCheckServlet-у. " +
                "Все запросы внутри приложения должны передаваться этому сервлету, остальные сервлеты с веб-страниц " +
                "напрямую вызываться не должны.";
    }
}
