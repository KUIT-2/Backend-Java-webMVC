package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


public class HomeController extends AbstractController {
    private final MemoryQuestionRepository memoryQuestionRepository= MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        List<Question> questions = memoryQuestionRepository.findAll();
        return jspView("/home.jsp").addModel("questions", questions);
    }
}
