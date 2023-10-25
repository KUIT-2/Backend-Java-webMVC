package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpSession;

public abstract class AbstractController implements Controller {

    protected ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    protected ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
