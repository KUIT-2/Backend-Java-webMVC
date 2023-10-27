package core.mvc;

import core.view.JsonView;
import core.view.JspView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller{
    protected ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    protected ModelAndView jsonView() {
        return new ModelAndView(new JsonView());
    }
}
