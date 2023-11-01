package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.User;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class UpdateUserFormController extends AbstractController {
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        String userId = params.get("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            return jspView("/user/updateForm.jsp").addData("user", user);
        }
        return jspView("redirect:/");
    }

    @Override
    public void setSession(HttpSession session) {
        super.setSession(session);
    }

}
