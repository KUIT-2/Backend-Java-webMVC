package jwp.controller;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.Question;
import java.util.List;
import java.util.Map;


public class HomeController extends AbstractController {
    private final MemoryQuestionRepository memoryQuestionRepository= MemoryQuestionRepository.getInstance();


    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        List<Question> questions = memoryQuestionRepository.findAll();
        return jspView("/home.jsp").addData("questions", questions);
    }
}
