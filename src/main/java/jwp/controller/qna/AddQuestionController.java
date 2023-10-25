package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class AddQuestionController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        Question question = new Question(MemoryQuestionRepository.getPK(), params.get("writer"), params.get("title"), params.get("contents"), Date.valueOf(LocalDate.now()), 0);
        questionRepository.insert(question);

        return jspView("redirect:/");
    }
}
