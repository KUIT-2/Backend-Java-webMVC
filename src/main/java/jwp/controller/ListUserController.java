package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
//            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return jspView("/user/list.jsp").addAttribute("users",
                    MemoryUserRepository.getInstance().findAll());
        }
        return jspView("redirect:/user/loginForm");
    }
}
