package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateUserFormController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            ModelAndView mav = new ModelAndView(new JspView("/user/updateForm.jsp"));
            mav.addModelElement("user",user);
            return mav;
        }
        return new ModelAndView(new JspView("redirect:/"));
    }
}
