package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.Answer;
import jwp.model.Question;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowController extends AbstractController {
    private final MemoryQuestionRepository memoryQuestionRepository = MemoryQuestionRepository.getInstance();
    private final MemoryAnswerRepository memoryAnswerRepository = MemoryAnswerRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String questionId = request.getParameter("questionId");
        Question question = memoryQuestionRepository.findByQuestionId(questionId);
        List<Answer> answers = memoryAnswerRepository.findAllByQuestionId(questionId);

        ModelAndView mav = jspView("/qna/show.jsp");
        mav.addModelElement("question", question).addModelElement("answers",answers);
        return mav;
    }
}
