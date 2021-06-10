package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberInsert implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberInsert서비스클래스");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MemberDTO member = new MemberDTO();
		
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setMailid(request.getParameter("mailid"));
		member.setDomain(request.getParameter("domain"));
		member.setPost(request.getParameter("post"));
		member.setAddress(request.getParameter("address"));
		member.setBirth(request.getParameter("birth"));
		member.setPhone1(request.getParameter("phone1"));
	    member.setPhone2(request.getParameter("phone2"));
		member.setPhone3(request.getParameter("phone3"));
		member.setSex(request.getParameter("sex"));

		MemberDAO dao = MemberDAO.getIstance();
		int result = dao.insert(member);
		
		if(result==1) {
			System.out.println("회원가입성공");
	
			
		}else {
			System.out.println("회원가입실패");
			out.println("<script>");
			out.println("alert('회원가입에 실패하였습니다. 아이디중복체크를 확인해 보세요');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/loginform.jsp");
		
		return forward;
	}

}
