package rebootServlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/rebootServlet/mypage.do")
public class MypageController extends HttpServlet {

    public MypageController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
    	
		
		ProfileDTO dto = new ProfileDTO();
		ProfileDAO pDao = new ProfileDAO();
		dto = pDao.getMember(id);

		req.setAttribute("dto", dto);
		

		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Reboot/MyPage.jsp").forward(req, resp);
    }
}
