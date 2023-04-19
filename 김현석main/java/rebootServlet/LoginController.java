package rebootServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;
import utils.ManageCookie;

@WebServlet("/rebootServlet/login.do")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//매개변수 저장
				String id = req.getParameter("id");
				String pass = req.getParameter("pass");
				
				String user_id=req.getParameter("id");
				String save_check=req.getParameter("remember");
				
				System.out.println(user_id);
				System.out.println(save_check);
				
				
				System.out.println(id);
				System.out.println(pass);
				
				RebootDAO dao = new RebootDAO();
				boolean confirmedid = dao.confirmid(id);
				boolean confirm = dao.confirmPassword(id, pass);
				dao.close();
				
				if(confirmedid==true) { //아이디 일치
					if(confirm) { //비번 일치 
						if(save_check!=null&&save_check.equals("Y")){
							ManageCookie.makeCookie(resp, "loginId",user_id,86400);
						}else {
							ManageCookie.deleteCookie(resp,"loginId");
						}
						AlertFunc.alertLocation(resp, "로그인 되었습니다.", "../Reboot/Main.jsp");
					}else { //비번 불 일치
						AlertFunc.alertBack(resp, "비번이 틀립니다.");
					}
				} else {//아이디 불 일치
					AlertFunc.alertBack(resp, "사번이 존재하지 않습니다.");
				}	
	}
}