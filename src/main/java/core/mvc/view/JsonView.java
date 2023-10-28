package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View{

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson library
        writer.write(objectMapper.writeValueAsString(model));
        writer.flush();
    }
}
