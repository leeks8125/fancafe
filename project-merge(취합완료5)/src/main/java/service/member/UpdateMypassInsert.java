package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class UpdateMypassInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateMypassInsert서비스클래스");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("newpass"));
		
		MemberDAO dao = MemberDAO.getIstance();
		
		int result = dao.updatepassinsert(member);
		
		if(result == 1) {
			System.out.println("비밀번호 변경 성공");
		}else {
			out.println("<script>");
			out.println("alert('비밀버호 변경 실패');");
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
