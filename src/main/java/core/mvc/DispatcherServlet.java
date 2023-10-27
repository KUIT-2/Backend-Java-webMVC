package core.mvc;

import core.mvc.view.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public void init() {
        requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Controller controller = requestMapping.getController(req);
        if (controller == null) {
            return;
        }
        try {
            ModelAndView mav = controller.execute(req, resp);
            mav.render(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }
}
