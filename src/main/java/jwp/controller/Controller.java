package jwp.controller;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface Controller {
    void execute(ServletRequest request, ServletResponse response) throws IOException, ServletException;
}
