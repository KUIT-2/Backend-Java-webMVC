package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class LogInController extends AbstractController {

    private HttpSession session;
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        User loginUser = new User(params.get("userId"),params.get("password"));
        User user = MemoryUserRepository.getInstance().findUserById(params.get("userId"));
        if (user != null && user.isSameUser(loginUser)) {
            session.setAttribute("user", user);
            return jspView("redirect:/");
        }
        return jspView("redirect:/user/loginFailed");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

}
