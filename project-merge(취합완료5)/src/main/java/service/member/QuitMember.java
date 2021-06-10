package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class QuitMember implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QuitMember서비스클래스");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDAO dao = MemberDAO.getIstance();
		MemberDTO member = dao.getmyinfo(id);
		System.out.println("탈퇴폼:"+member);
		
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/quitmemberform.jsp");
		
		return forward;
	}

}
