package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.ModelBean;
import service.Action;
import service.ActionForward;

public class Boardmodifyaction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boardmodifyaction");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		BoardDao dao = BoardDao.getInstance();
		ModelBean mboard = dao.getDetail(num);
		
		request.setAttribute("mboard", mboard);	    // 공유 설정
		request.setAttribute("page", page);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/board_modify.jsp"); // 수정 폼
		
		return forward;
	}

}
