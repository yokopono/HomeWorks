package twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static twitter.TweeterServlet.service;

@WebServlet(urlPatterns = "/twitter/com")
public class CommentsTweeterServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String comm = req.getParameter("commentMessage");
        String id= req.getParameter("idComment");
        long l = Long.parseLong(id);
        service.addComment(l,comm);
        resp.sendRedirect("/twitter");
    }

}
