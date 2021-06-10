package service.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.ModelBean;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boarddetailaction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Boarddetailaction");
		
		int num=Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		BoardDao dao = BoardDao.getInstance();
		dao.readcountUpdate(num);
		ModelBean mboard = dao.getDetail(num);
		
		// 글내용에서 줄바꿈
String content=mboard.getContent().replace("\n","<br>");
		List<RemodelBean> listre = new ArrayList<RemodelBean>();
		listre = dao.getListre(num);
		System.out.println(listre);
		
		// 공유 설정
		request.setAttribute("content", content);
		request.setAttribute("mboard", mboard);
		request.setAttribute("page", page);
		request.setAttribute("listre", listre);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/board_view.jsp");
		
		return forward;
	}

}
