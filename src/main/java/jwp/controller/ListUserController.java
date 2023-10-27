package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.util.UserSessionUtils;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            ModelAndView mav = new ModelAndView(new JspView("/user/list.jsp"));
            mav.addModelElement("users", MemoryUserRepository.getInstance().findAll());
            return mav;
        }
        return new ModelAndView(new JspView("redirect:/user/loginForm"));
    }
}
