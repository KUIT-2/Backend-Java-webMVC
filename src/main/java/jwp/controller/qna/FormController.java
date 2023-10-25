package jwp.controller.qna;

import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class FormController extends AbstractController {

    HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        if (UserSessionUtils.isLogined(session)) {
            return jspView("/qna/form.jsp");
        }
        return jspView("redirect:/user/loginForm");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
