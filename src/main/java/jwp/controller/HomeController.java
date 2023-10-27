package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.Question;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class HomeController extends AbstractController {
    private final MemoryQuestionRepository memoryQuestionRepository= MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Question> questions = memoryQuestionRepository.findAll();

        ModelAndView mav = jspView("/home.jsp");
        mav.addModelElement("questions",questions);
        return mav;
    }
}
