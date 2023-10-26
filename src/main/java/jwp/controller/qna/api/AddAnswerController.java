package jwp.controller.qna.api;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.JsonView;
import core.mvc.view.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Answer answer = new Answer(MemoryAnswerRepository.getPK(),Integer.parseInt(req.getParameter("questionId")), req.getParameter("writer"), req.getParameter("contents"), Date.valueOf(LocalDate.now()));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findByQuestionId(Integer.toString(answer.getQuestionId()));
        question.increaseCountOfAnswer();

        questionRepository.updateCountOfAnswer(question);

        ModelAndView mav = jsonView();
        mav.addModel("answer", savedAnswer);

        return mav;
    }
}
