package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View {

    public JsonView(){
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Jackson 패키지 사용
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        for (String key : model.keySet()) {
            out.print(mapper.writeValueAsString(model.get(key)));
        }
    }
}
