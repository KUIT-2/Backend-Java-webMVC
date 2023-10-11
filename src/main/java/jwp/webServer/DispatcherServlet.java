package jwp.webServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestMapper requestMapper = new RequestMapper(req, resp);
        String url = requestMapper.proceed();
        if (url.startsWith("redirect")) {
            String[] redirectUrl = url.split(":");
            resp.sendRedirect(redirectUrl[1]);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher(url + ".jsp");
            rd.forward(req,resp);
        }
    }
}
