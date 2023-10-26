package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class HomeController implements Controller{
    private final MemoryQuestionRepository memoryQuestionRepository= MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Question> questions = memoryQuestionRepository.findAll();
        req.setAttribute("questions",questions);
        return new ModelAndView(new JspView("/home.jsp"));
    }
}
