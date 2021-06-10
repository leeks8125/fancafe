package service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class NoticeModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeModifyAction");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		// 상세 정보
		NoticeBean notice = dao.getDetail(num);	
		
		request.setAttribute("notice", notice);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./notice/notice_modify.jsp");
		
		return forward;
	}

}
