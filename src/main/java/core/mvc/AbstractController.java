package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller {

    protected ModelAndView jspView(String path) {
        return new ModelAndView(new JspView(path));
    }

    protected ModelAndView jsonView(String path) {
        return new ModelAndView(new JsonView());
    }

}
