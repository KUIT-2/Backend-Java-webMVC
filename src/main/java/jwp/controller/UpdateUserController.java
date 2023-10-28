package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateUserController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        MemoryUserRepository.getInstance().update(new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")));
        return jspView("redirect:/user/list") ;

    }
}
