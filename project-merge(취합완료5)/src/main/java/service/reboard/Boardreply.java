package service.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boardreply implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boardreply");
		
		request.setCharacterEncoding("utf-8");  // 한글 인코딩
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		System.out.println("page" + page);
		String content1 = request.getParameter("content1");
	
		System.out.println(content1);
		RemodelBean rmboard = new RemodelBean();
		rmboard.setId(request.getParameter("id"));
		rmboard.setNum(num);
		rmboard.setContent(content1);
		
		
		BoardDao dao = BoardDao.getInstance();
		int result = dao.boardreply(rmboard);   // 댓글 작성
		if(result == 1) {
			System.out.println("댓글 작성 성공");
		}else {
			System.out.println("댓글 작성 실패");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Boarddetailaction.ks?num="+num+"&page="+page);
		
		return forward;
	}

}
