package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UpdateQuestionController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return new ModelAndView(new JspView("redirect:/users/loginForm"));
        }

        String questionId = req.getParameter("questionId");
        Question question = questionRepository.findByQuestionId(questionId);

        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            throw new IllegalArgumentException();
        }

        question.updateTitleAndContents(req.getParameter("title"),req.getParameter("contents"));
        questionRepository.update(question);

        return jspView("redirect:/");
    }
}
