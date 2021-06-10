package service.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MainAction");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		List<NoticeBean> noticelist = dao.getList(1, 5);
		System.out.println("noticelist :"+ noticelist);
		
		// request 공유
		request.setAttribute("noticelist", noticelist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./common/main.jsp");
		
		return forward;
	}

}
