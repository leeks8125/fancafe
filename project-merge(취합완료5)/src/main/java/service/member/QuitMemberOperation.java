package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class QuitMemberOperation implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QuitMemberOperation서비스클래스");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		
		MemberDAO dao = MemberDAO.getIstance();
		MemberDTO past = dao.getmyinfo(member.getId());
		
		if(past.getPass().equals(member.getPass())) {
			int result = dao.quitmemberoperation(member);
			if(result == 1) {
				System.out.println("회원탈퇴성공");
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/member/logoutquit.jsp");
				
				return forward;
			}
				
		}else {
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/common/main.jsp");
		
		return forward;
	}

}
