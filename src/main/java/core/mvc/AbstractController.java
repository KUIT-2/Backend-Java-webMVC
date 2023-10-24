package core.mvc;

import core.mvc.view.ModelAndView;

public abstract class AbstractController implements Controller{
    public abstract ModelAndView jspView();
    public abstract ModelAndView jsonView();
}
