package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaDelete_1 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaDelete_1");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String check = request.getParameter("check");
		String grade = request.getParameter("grade");
		
		
		QnaDAO dao = QnaDAO.getInstance();

		
		

		// 관리자 확인
		if (check.equals("삭제확인")) { 
			if(grade.equals("1")) {
				int result = dao.delete(num);
				
				if(result == 1) {
					System.out.println("글 삭제 성공");
				}
			}
		} else {										 // 체크 메세지 불일치
			out.println("<script>");
			out.println("alert('확인 메세지 오류');");
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
