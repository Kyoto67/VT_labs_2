package servlets;

import exception.WrongValueException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import verifyer.DataChecker;
import verifyer.Result;
import verifyer.ResultContainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        ResultContainer tableContent = (ResultContainer) session.getAttribute("tableContent");
        if (tableContent == null) tableContent = new ResultContainer();
        List<Result> results = tableContent.getResults();
        ArrayList<Double> x = new ArrayList<>();
        try {
            try {
                x.add(Double.parseDouble(request.getParameter("x")));
            } catch (Exception e) {
                x = parseXValues(request.getParameter("x"));
            }
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));
            int timeShift = Integer.parseInt(request.getParameter("time"));
            Date date = new Date();
            date.setHours(date.getHours() - timeShift / 60);
            x.forEach((x_value) -> {
                DataChecker dataChecker = new DataChecker(x_value, y, r);
                try {
                    if (dataChecker.verification())
                        results.add(new Result(results.size() + 1, x_value, y, r, dataChecker.hitCheck(), "0.00" +
                                (System.currentTimeMillis() - starttime) + "s" , date.toString()));
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
        } catch (Exception e) {
            response.sendError(404);
        }
        writer.println(resultsToJSON(results));
        writer.close();
        session.setAttribute("tableContent", tableContent);
    }

//    private String pointToString(double x, double y, double r, boolean coordsStatus, int number, int timeShift) {
//
//        System.out.println("COMPLETE TASK:  x="+x+"; y="+y+"; r="+r+"; result="+coordsStatus);
//        return "<tr><td>" + number + "</td>"
//                + "<td>" + x + "</td>" +
//                "<td>" + y + "</td>" +
//                "<td>" + r + "</td>" +
//                "<td style='color: " + ((coordsStatus) ? "green" : "red") + "'>" + coordsStatus + "</td>" +
//                "<td></td>" +
//                "<td>" + date + "</td></tr>";
//    }

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
        for (String s : array) valuesX.add(Double.parseDouble(s));
        return valuesX;
    }

    private String resultsToJSON(List<Result> results) {
        String[] output = {"["};
        results.forEach( (obj) -> output[0]+= obj.toString() + ", \n");
        output[0] = output[0].substring( 0, output[0].length() - 3);
        output[0] += "]";
        return output[0];
    }
}

