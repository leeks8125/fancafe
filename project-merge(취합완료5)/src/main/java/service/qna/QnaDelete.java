package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaDelete");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String passwd = request.getParameter("passwd");
		
		
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaBean old = dao.getDetail(num);
		
		


			// 비번 비교
		if(old.getPasswd().equals(passwd)) { // 비번 일치시
			int result = dao.delete(num); {
			if(result == 1) {
				System.out.println("글 삭제 성공");
				}
			}
		}else {										 // 비번 불일치시
			out.println("<script>");
			out.println("alert('글 삭제 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/QnaListAction.jy?page=" + page);
		
		return forward;
	}
		
}
