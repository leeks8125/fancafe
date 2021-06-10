package service.reboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class Boardreplydelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("Boardreplydelete");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		String myid = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String pass = request.getParameter("pass");
		int re_seq =Integer.parseInt(request.getParameter("re_seq"));
		BoardDao dao = BoardDao.getInstance();
		MemberDTO board = dao.getPass(myid);
		
		// 비번 비교
		if (board.getPass().equals(pass)) { // 비번 일치시
			int result = dao.deletere(num,re_seq);
			if (result == 1)
				System.out.println("댓글삭제 성공");
		} else { // 비번 불일치시
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();

			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Boardlistaction.ks?page=" + page);

		return forward;
	}
}
