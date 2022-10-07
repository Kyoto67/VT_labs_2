package servlets;

import exception.WrongValueException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import verifyer.DataChecker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AreaCheck", value = "/areacheck")
public class AreaCheckServlet extends HttpServlet {

    long starttime = System.currentTimeMillis();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        starttime = System.currentTimeMillis();
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        List<String> tableRows = (List) session.getAttribute("tableRows");
        if (tableRows == null || tableRows.size() == 0) {
            tableRows = new ArrayList<String>();
            tableRows.add("<table border=\"1\" class=\"resultTable\">\n" +
                    "        <tr>\n" + "            <td class=\"cellNum\">Num</td>\n" +
                    "            <td class=\"cellNum\">X</td>\n" +
                    "            <td class=\"cellNum\">Y</td>\n" +
                    "            <td class=\"cellNum\">R</td>\n" +
                    "            <td class=\"cellRes\">Result</td>\n" +
                    "            <td class=\"cellTime\">Working time</td>\n" +
                    "            <td class=\"cellTime\">Current time</td>\n" +
                    "        </tr>");
            tableRows.add("    </table>\n");
        }
        tableRows.remove(tableRows.size() - 1);
        ArrayList<Double> x = new ArrayList<>();
        try {
            x.add(Double.parseDouble(request.getParameter("x")));
        } catch (Exception e) {
            x = parseXValues(request.getParameter("x"));
        }
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));
        int timeShift = Integer.parseInt(request.getParameter("time"));
        List<String> finalTableRows = tableRows;
        x.forEach((x_value) -> {
            DataChecker dataChecker = new DataChecker(x_value, y, r);
            try {
                if (dataChecker.verification())
                    finalTableRows.add(pointToString(x_value, y, r, dataChecker.hitCheck(), finalTableRows.size(), timeShift));
            } catch (WrongValueException e) {
                response.setStatus(480);
                request.setAttribute("error_message", e.getMessage());
                try {
                    getServletContext().getRequestDispatcher("/wrong_data.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        finalTableRows.add("    </table>\n");
        for (String tableRow : finalTableRows) writer.println(tableRow);
        writer.close();
        session.setAttribute("tableRows", finalTableRows);
    }

    private String pointToString(double x, double y, double r, boolean coordsStatus, int number, int timeShift) {
        Date date = new Date();
        date.setHours(date.getHours() - timeShift / 60);
        System.out.println("COMPLETE TASK:  x="+x+"; y="+y+"; r="+r+"; result="+coordsStatus);
        return "<tr><td>" + number + "</td>"
                + "<td>" + x + "</td>" +
                "<td>" + y + "</td>" +
                "<td>" + r + "</td>" +
                "<td style='color: " + ((coordsStatus) ? "green" : "red") + "'>" + coordsStatus + "</td>" +
                "<td>0.00" + (System.currentTimeMillis() - starttime) + "s</td>" +
                "<td>" + date + "</td></tr>";
    }

    @Override
    public String getServletInfo() {
        return "servlets.AreaCheckServlet - осуществляет проверку попадания точки в область на координатной плоскости и " +
                "формирует HTML-страницу с результатами проверки. Должен обрабатывать все запросы, " +
                "содержащие сведения о координатах точки и радиусе области.";
    }

    private ArrayList<Double> parseXValues(String rawArray) {
        ArrayList<Double> valuesX = new ArrayList<>();
        rawArray = rawArray.substring(1, rawArray.length() - 1);
        String[] array = rawArray.split(",");
        for (String s : array) valuesX.add(Double.parseDouble(s.substring(1, s.length() - 1)));
        return valuesX;
    }
}
