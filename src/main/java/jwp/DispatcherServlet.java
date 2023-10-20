package jwp;

import core.db.Repository;
import jwp.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        RequestMapper requestMapper = new RequestMapper(httpRequest, httpResponse);
        requestMapper.proceed();
    }
}
