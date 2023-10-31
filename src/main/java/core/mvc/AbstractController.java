package core.mvc;

import core.mvc.view.JsonView;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller{

    //interface로 정의하는게 아니라 abstract 클래스를 사용하게 되면 모든 메소드를 override 할 필요 없이 필요한 것만 override 하면 된다.
    protected ModelAndView jspView(String url){
        return new ModelAndView(new JspView(url));
    }

    protected ModelAndView jsonView(){
        return new ModelAndView(new JsonView());
    }
}
