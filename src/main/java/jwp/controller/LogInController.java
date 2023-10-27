package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogInController extends AbstractController {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User logInUser = new User(userId, password);
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(logInUser)) {
            session.setAttribute("user", user);

            return jspView("redirect:/");
        }
        return jspView("redirect:/user/loginFailed");
    }
}
