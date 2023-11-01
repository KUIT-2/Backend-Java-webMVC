package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class ListUserController extends AbstractController {

    private HttpSession session;

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        if (UserSessionUtils.isLogined(session)) {
            session.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return jspView("/user/list.jsp");
        }
        return jspView("redirect:/user/loginForm");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
