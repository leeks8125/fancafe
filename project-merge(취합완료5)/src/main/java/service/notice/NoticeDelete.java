package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import service.Action;
import service.ActionForward;

public class NoticeDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDelete");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String grade = request.getParameter("grade");
		String check = request.getParameter("check");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		// 관리자 등급, 체크용 문자 검사
		if (check.equals("지금삭제")) {
			if(grade.equals("1")) {
				int result = dao.delete(num);
				
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
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/NoticeListAction.sh?page=" + page);
		
		return forward;
	}

}
