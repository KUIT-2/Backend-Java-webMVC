package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ShowController extends AbstractController {
    private final MemoryQuestionRepository memoryQuestionRepository = MemoryQuestionRepository.getInstance();
    private final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        String questionId = params.get("questionId");
        Question question = memoryQuestionRepository.findByQuestionId(questionId);
        List<Answer> answers = memoryAnswerRepository.findAllByQuestionId(questionId);
        return jspView( "/qna/show.jsp").addModel("question", question).addModel("answers", answers);
    }
}
