package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import java.util.Map;


public class UpdateUserController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        MemoryUserRepository.getInstance().update(new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email")));
        return jspView("redirect:/user/list");
    }
}
