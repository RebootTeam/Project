package profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProfileDAO dao = new ProfileDAO();
        ProfileDTO pdto = dao.getMember(id);
        request.setAttribute("pdto", pdto);
        RequestDispatcher rd = request.getRequestDispatcher("Profile.jsp");
        rd.forward(request, response);
    }
}
   