package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.view.ModelAndView;
import jwp.model.Question;
import jwp.util.UserSessionUtils;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

public class UpdateQuestionFormController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    private HttpSession session;

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        if (!UserSessionUtils.isLogined(session)) {
            return jspView("redirect:/users/loginForm");
        }
        String questionId = params.get("questionId");
        Question question = questionRepository.findByQuestionId(questionId);
        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            return jspView("/qna/show?questionId=" + questionId);
        }
        return jspView("/qna/updateForm.jsp").addData("question", question);
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
