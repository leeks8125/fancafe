package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaModify");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
//		String grade = request.getParameter("grade");
		
		QnaBean qna = new QnaBean();
		qna.setNum(num);
		qna.setSubject(request.getParameter("subject"));
		qna.setContent(request.getParameter("content"));
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaBean old = dao.getDetail(num);
		
		// 비밀번호 비교
		if (old.getPasswd().equals(passwd)) {
			int result = dao.update(qna);
			if(result == 1) {
				System.out.println("글 수정 성공");
			}
			
		} else {
		
			out.println("<script>");
			out.println("alert('작성자가 일치하지 않습니다')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
			} 

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/QnaDetailAction.jy?num="+ num + "&page=" + page);
		
		return forward;
	}

}
