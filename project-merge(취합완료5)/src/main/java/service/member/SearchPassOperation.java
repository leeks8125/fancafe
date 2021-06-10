package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class SearchPassOperation implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SearchPassOperation서비스클래스");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mailid = request.getParameter("mailid");
		String domain = request.getParameter("domain");
		
		MemberDAO dao = MemberDAO.getIstance();
		
		MemberDTO member = dao.getmypass(id, name, mailid, domain);
		
		if(member != null) {
			request.setAttribute("member", member);
		}else {
			out.println("<script>");
			out.println("alert('비밀번호를 구하지 못하였습니다');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/view_mypass.jsp");
		
		return forward;
	}

}
