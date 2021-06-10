package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class NoticeModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeModify");
		
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		String grade = request.getParameter("grade");
		
		NoticeBean notice = new NoticeBean();
		notice.setNum(num);
		notice.setSubject(request.getParameter("subject"));
		notice.setContent(request.getParameter("content"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeBean old = dao.getDetail(num);
		
		// 관리자 검사 : 아이디, 등급
		if (old.getId().equals(id) && grade.equals("1")) {
			int result = dao.update(notice);
			
			if (result == 1) {
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
		forward.setPath("/NoticeDetailAction.sh?num="+ num + "&page=" + page);
		
		return forward;
	}

}
