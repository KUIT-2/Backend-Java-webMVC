package core.mvc.view;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspView implements View {

    private final String viewName;
    private static final String REDIRECT = "redirect:";

    public JspView(String viewName) {
        this.viewName = viewName;
    }

//    기존 DispatcherServlet에서 경로에 따라 move를 해야 했지만, 이를 JspView로 가져옴 왜? 반환 데이터의 타입이 다양해짐에 따라
    @Override
    public void render(HashMap<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (viewName.startsWith(REDIRECT)) {
            response.sendRedirect(viewName.substring(REDIRECT.length()));
            return;
        }

        //request에 model 저장
        for (String key : model.keySet()) {
            request.setAttribute(key, model.get(key));
        }

        RequestDispatcher rd = request.getRequestDispatcher(viewName);
        rd.forward(request, response);
    }
}
