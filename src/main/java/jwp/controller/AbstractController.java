package jwp.controller;

import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (req.getMethod().equals(HttpMethod.GET)) {
            doGet(req, res);
            return;
        }
        doPost(req, res);
    }

    abstract void doGet(HttpServletRequest req, HttpServletResponse res);
    abstract void doPost(HttpServletRequest req, HttpServletResponse res);
}
