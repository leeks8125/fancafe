package service.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import service.Action;
import service.ActionForward;

public class AdminDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminDelete");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		String grade = request.getParameter("grade");
		String check = request.getParameter("check");
		
		AdminDAO dao = AdminDAO.getInstance();
		
		// 관리자 등급, 체크용 문자 검사
		if (check.equals("회원탈퇴")) {
			if(grade.equals("1")) {
				int result = dao.delete(id);
				
				if(result == 1) {
					System.out.println("탈퇴 성공");
				}
			} else {
				out.println("<script>");
				out.println("alert('탈퇴시킬 수 없습니다.')");
				out.println("history.go(-1)");
				out.println("</script>");
				out.close();
				
				return null;
			}
			
		} else {
			out.println("<script>");
			out.println("alert('정확히 입력해주세요.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AdminListAction.sw?page=" + page);
		
		return forward;
	}

}
