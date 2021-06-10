package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.ModelBean;
import service.Action;
import service.ActionForward;

public class Boardaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		ModelBean mboard = new ModelBean();
		mboard.setId(request.getParameter("id"));
		mboard.setSubject(request.getParameter("subject"));
		mboard.setContent(request.getParameter("content"));
		
		BoardDao dao = BoardDao.getInstance();
		int result = dao.insert(mboard);
		if(result == 1) {
			System.out.println("글작성 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Boardlistaction.ks");
		
		return forward;
	}

}
