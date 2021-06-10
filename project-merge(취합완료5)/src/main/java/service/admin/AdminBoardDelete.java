package service.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import service.Action;
import service.ActionForward;

public class AdminBoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminBoardDelete");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String grade = request.getParameter("grade");
		String check = request.getParameter("check");
		String flag = request.getParameter("flag");
		System.out.println("grade" + grade);
		System.out.println("flag" + flag);
		
		AdminDAO dao = AdminDAO.getInstance();
		
		ActionForward forward = new ActionForward();
		
		// 관리자 등급, 체크용 문자 검사
		if (check.equals("지금삭제")) {
			int result = 0;
			
			// 등급 검사
			if (grade.equals("1")) {
				
				// 게시판 분류
				if (flag.equals("b")) {
					result = dao.deleteBoard(num);
					
					forward.setRedirect(false);
					forward.setPath("/Boardlistaction.ks?page=" + page);
					
				} else if(flag.equals("r")) {
					int reSeq = Integer.parseInt(request.getParameter("re_seq"));
					
					result = dao.deleteReboard(num, reSeq);
					
					forward.setRedirect(false);
					forward.setPath("/Boardlistaction.ks?page=" + page);
					
				}
				
				if(result == 1) {
					System.out.println("글 삭제 성공");
				}
			} else {
				out.println("<script>");
				out.println("alert('삭제할 수 없습니다.')");
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
		
		return forward;
	}

}
