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


public class UpdateUserFormController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            req.setAttribute("user",user);
            return jspView("/user/updateForm.jsp") ;
        }
        return jspView("redirect:/");
    }
}
