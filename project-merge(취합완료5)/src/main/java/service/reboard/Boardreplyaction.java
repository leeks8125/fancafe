package service.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boardreplyaction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boardreplyaction");
		
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		BoardDao dao = BoardDao.getInstance();
		RemodelBean rmboard = dao.getDetailreply(num,re_seq); //상세정보 구하기
		
		
		request.setAttribute("rmboard", rmboard);
		request.setAttribute("page", page);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);   // dispatcher 방식으로 포워딩
		forward.setPath("./board/board_view.jsp" ); //댓글 폼
		
		
		return forward;
	}

}
