package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class UpdateUserController extends AbstractController {
    private final MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        memoryUserRepository.update(new User(
                params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email")));
        return jspView("redirect:/user/list");

    }
}
