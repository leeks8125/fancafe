package service.member;   

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class Login implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Login서비스클래스");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDAO dao = MemberDAO.getIstance();
	
		int result = dao.login(id, pass);
		
		MemberDTO past = dao.getmyinfo(id);
		
		int admingrade = past.getGrade();
		System.out.println("관리자여부 "+admingrade);
		if(result==1) {
			System.out.println("result = " + result);
			if(past.getState() == 0) {
				System.out.println("state =" +past.getState());
				System.out.println("로그인 성공");

				session.setAttribute("id", id);
				session.setAttribute("grade", admingrade);
				
			}else {
				System.out.println("state =" +past.getState());
				out.println("<script>");
				out.println("alert('로그인실패')");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				
				return null;
			}
			 
		}else {
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/MainAction.do");
		
		return forward;
	}

}
