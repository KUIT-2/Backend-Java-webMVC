package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import core.mvc.view.JspView;
import jwp.model.Question;
import jwp.util.UserSessionUtils;
import org.apache.tomcat.util.log.UserDataHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UpdateQuestionFormController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return jspView("redirect:/users/loginForm");
        }

        String questionId = req.getParameter("questionId");
        Question question = questionRepository.findByQuestionId(questionId);

        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            return jspView("/qna/show?questionId=" + questionId);
        }

        ModelAndView mav = jspView("/qna/updateForm.jsp");
        mav.addModelElement("question", question);
        return mav;
    }
}
