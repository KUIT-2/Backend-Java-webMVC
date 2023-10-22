package core.mvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private static final String REDIRECT = "redirect:";

    @Override
    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Controller controller = handlerMapping.getController(req);
        try {
            String viewName = controller.handleRequest(req, resp);
            move(viewName, req, resp);
        } catch (Throwable throwable) {
            throw new ServletException(throwable.getMessage());
        }
    }

    private void move(String viewName, HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        if (viewName.startsWith(REDIRECT)) {
            resp.sendRedirect(viewName.substring(REDIRECT.length()));
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        rd.forward(req, resp);
    }
}
