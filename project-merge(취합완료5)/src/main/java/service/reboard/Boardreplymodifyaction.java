package service.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boardreplymodifyaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boardreplymodifyaction");
		int num = Integer.parseInt(request.getParameter("num"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		String page = request.getParameter("page");
		BoardDao dao = BoardDao.getInstance();
		RemodelBean rmboard = dao.getDetailreply(num,re_seq);
		request.setAttribute("rmboard", rmboard);
		request.setAttribute("page", page);
		request.setAttribute("re_seq", re_seq);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./reboard/reboard_replymodify.jsp"); // 수정 폼
		
		return forward;
	}

}
