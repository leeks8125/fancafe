package service.reboard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boardreplydeleteaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boarddetailaction");
		
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int num=Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		BoardDao dao =BoardDao.getInstance();
		RemodelBean rmboard = dao.getDetailreply(num,re_seq);
		
		List<RemodelBean> listre = new ArrayList<RemodelBean>();
		listre = dao.getListre(num);
		System.out.println(listre);
		
		// 공유 설정
		request.setAttribute("page", page);
		request.setAttribute("listre", listre);
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/board_view.jsp");
		
		return forward;
	}

}
