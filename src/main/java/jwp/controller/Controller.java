package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    void execute(HttpServletRequest req, HttpServletResponse res) throws IOException;
}