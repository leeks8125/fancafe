package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import service.Action;
import service.ActionForward;

public class IdCheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IdCheck서비스클래스");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println("id: "+id);
		
		MemberDAO dao = MemberDAO.getIstance();
		int result = dao.idcheck(id);
		System.out.println("result: "+result);  // 1중복 ID
		
		out.println(result);
		
		return null;
	}

}
