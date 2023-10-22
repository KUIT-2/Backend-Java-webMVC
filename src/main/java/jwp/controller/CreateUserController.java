package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;

import java.util.Map;


public class CreateUserController extends AbstractController {

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        User user = new User(params.get("userId"),params.get("password"),params.get("name"),params.get("email"));
        MemoryUserRepository.getInstance().addUser(user);
        return jspView("redirect:/");
    }
}
