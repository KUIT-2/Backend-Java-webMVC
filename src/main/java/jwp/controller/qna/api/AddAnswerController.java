package jwp.controller.qna.api;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class AddAnswerController extends AbstractController {
    private final MemoryAnswerRepository answerRepository = MemoryAnswerRepository.getInstance();
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        Answer answer = new Answer(MemoryAnswerRepository.getPK(),Integer.parseInt(params.get("questionId")),
                params.get("writer"),
                params.get("contents"),
                Date.valueOf(LocalDate.now()));
        Answer savedAnswer = answerRepository.insert(answer);

        Question question = questionRepository.findByQuestionId(Integer.toString(answer.getQuestionId()));
        question.increaseCountOfAnswer();

        questionRepository.updateCountOfAnswer(question);

        return jsonView().addData("savedAnswer", savedAnswer);
    }

}
