package jwp.controller.qna;

import core.db.MemoryAnswerRepository;
import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.Answer;
import jwp.model.Question;
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
        ModelAndView mav = jspView("/qna/show.jsp");
        mav.addData("question", question);
        mav.addData("answers",answers);
        return mav;
    }
}
