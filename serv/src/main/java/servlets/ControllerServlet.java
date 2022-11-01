package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/app")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/areacheck").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public String getServletInfo() {
        return "servlets.ControllerServlet - определяет тип запроса, и, в зависимости от того, содержит ли запрос информацию " +
                "о координатах точки и радиусе, делегирует его обработку стартовой jsp-странице или servlets.AreaCheckServlet-у. " +
                "Все запросы внутри приложения должны передаваться этому сервлету, остальные сервлеты с веб-страниц " +
                "напрямую вызываться не должны.";
    }
}
