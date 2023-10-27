package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormController implements Controller {
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (UserSessionUtils.isLogined(session)) {
            return new ModelAndView(new JspView("/qna/form.jsp"));
        }
        return new ModelAndView(new JspView("redirect:/user/loginForm"));
    }
}
