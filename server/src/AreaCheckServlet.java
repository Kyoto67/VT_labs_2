import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        List<String> tableRows = (List) session.getAttribute("tableRows");
        if (tableRows == null) {
            //...
        }
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));
        PrintWriter writer = response.getWriter();
        DataChecker dataChecker = new DataChecker(x, y, r);
        if (dataChecker.verification()) {
            tableRows.add(pointToString(x, y, r, dataChecker.hitCheck()));
            for (String tableRow: tableRows) writer.println(tableRow);
        } else response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        writer.close();
    }

    private String pointToString(double x, double y, double r, boolean coordsStatus) {
        return "<tr><td>" + x + "</td>" +
                "<td>" + y + "</td>" +
                "<td>" + r + "</td>" +
                "<td style='color: " + ((coordsStatus) ? "green" : "red") + "'>" + coordsStatus + "</td>" +
                "<td>" + new Date().toString() + "</td></tr>";
    }

    @Override
    public String getServletInfo() {
        return "AreaCheckServlet - осуществляет проверку попадания точки в область на координатной плоскости и " +
                "формирует HTML-страницу с результатами проверки. Должен обрабатывать все запросы, " +
                "содержащие сведения о координатах точки и радиусе области.";
    }
}
