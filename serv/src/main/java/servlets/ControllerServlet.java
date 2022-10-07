package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/app")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("x") == null || request.getParameter("y") == null ||
                request.getParameter("r") == null || request.getParameter("time") == null) {
            response.setStatus(481);
            String error = "";
            if (request.getParameter("x") == null) error += "Missing X value\n";
            if (request.getParameter("y") == null) error += "Missing Y value\n";
            if (request.getParameter("r") == null) error += "Missing R value\n";
            if (request.getParameter("time") == null) error += "Missing TimeShift value\n";
            request.setAttribute("error_message", error);
            getServletContext().getRequestDispatcher("/wrong_data.jsp").forward(request, response);
        } else {
            getServletContext().getNamedDispatcher("AreaCheck").forward(request, response);
        }
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
