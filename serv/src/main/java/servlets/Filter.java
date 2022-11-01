package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/areacheck"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("x") == null || request.getParameter("y") == null ||
                request.getParameter("r") == null || request.getParameter("time") == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(481);
            String error = "";
            if (request.getParameter("x") == null) error += "Missing X value\n";
            if (request.getParameter("y") == null) error += "Missing Y value\n";
            if (request.getParameter("r") == null) error += "Missing R value\n";
            if (request.getParameter("time") == null) error += "Missing TimeShift value\n";
            request.setAttribute("error_message", error);
            request.getServletContext().getRequestDispatcher("/wrong_data.jsp").forward(request, httpServletResponse);
        } else {
            chain.doFilter(request, response);
        }
    }

        @Override
        public void destroy () {

        }
    }
