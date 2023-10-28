package core.mvc;

import jwp.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "dispatcher", urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {

    private RequestMapper requestMapper = new RequestMapper();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURL = req.getRequestURI();

        Controller controller = requestMapper.getController(requestURL);

        if (controller==null) {
            resp.sendError(404, "컨트롤러 없음");
            return;
        }

        String PATH;

        try {
            PATH = controller.excute(req, resp);
        } catch (Exception e) {
            throw new ServletException("Controller execution failed", e);
        }

        if (PATH.startsWith("redirect:")) {
            resp.sendRedirect(PATH.substring("redirect:".length()));
        } else {
            req.getRequestDispatcher(PATH).forward(req, resp);
        }

    }
}
