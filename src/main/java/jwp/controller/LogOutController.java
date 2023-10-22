package jwp.controller;

import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class LogOutController extends AbstractController {

    private HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        session.removeAttribute("user");
        return jspView("redirect:/");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
