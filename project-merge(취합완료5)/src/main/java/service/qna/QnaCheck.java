package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaCheck");

		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String passwd = request.getParameter("passwd");

		QnaDAO dao = QnaDAO.getInstance();
		QnaBean old = dao.getDetail(num);

		// 관리자 등급, 비밀번호 검사
		if (old.getPasswd().equals(passwd)) { // 비번 일치시
			System.out.println("비밀번호 일치");

		} else { // 비번 불일치시
			out.println("<script>");
			out.println("alert('비밀번호 불일치');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();

			return null;
		}


		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/QnaDetailAction.jy?page=" + page);

		return forward;
	}

}
