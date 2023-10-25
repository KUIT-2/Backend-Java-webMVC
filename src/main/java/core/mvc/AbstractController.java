package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;

public abstract class AbstractController implements Controller {

    private ModelAndView jspView(String url) {
        return new ModelAndView(new JspView(url));
    }

    private ModelAndView jsonView(String url) {
        return new ModelAndView(new JsonView());
    }
}
