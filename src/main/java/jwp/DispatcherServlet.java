package jwp;

import jwp.RequestMapper;
import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private RequestMapper requestMapper;
    private final String REDIRECT_DELIMITER = "redirect:";
    private final String JSP = ".jsp";

    public void init() {
        requestMapper = new RequestMapper();
    }

    private String setRedirectRequestUrl(String url) {
        return url.split(REDIRECT_DELIMITER)[1];
    }

    private String setForwardRequestUrl(String url) {
        return url + JSP;
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uri = req.getRequestURI();

        Controller ctrl = requestMapper.getController(uri);
        String url = ctrl.handleRequest(req, resp);
        if(url.contains(REDIRECT_DELIMITER)) {
            resp.sendRedirect(setRedirectRequestUrl(url));
            return;
        }
        //forward
        RequestDispatcher rd = req.getRequestDispatcher(setForwardRequestUrl(url));
        rd.forward(req, resp);
    }
}
