package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonView implements View {

//    AnswerController등의 경우 데이터 반환이기 때문에 return null을 할 경우
//    컨트롤러의 역할과 모순되기 때문에 Jackson 패키지를 사용하는 부분을 분리함 왜? jsp가 아닐 경우 계속 반복되니까
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(createModel(request)));
    }

    private Map<String, Object> createModel(HttpServletRequest request) {
        Enumeration<String> names = request.getAttributeNames();
        Map<String, Object> model = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            model.put(name, request.getAttribute(name));
        }
        return model;
    }
}
