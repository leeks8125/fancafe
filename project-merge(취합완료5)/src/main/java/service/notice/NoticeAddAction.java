package service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class NoticeAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeAddAction");
		
		request.setCharacterEncoding("utf-8");
		
		NoticeBean notice = new NoticeBean();
		notice.setId(request.getParameter("id"));
		notice.setSubject(request.getParameter("subject"));
		notice.setContent(request.getParameter("content"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		int result = dao.insert(notice);

		if(result == 1) {
			System.out.println("글작성 성공");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./NoticeListAction.sh");
		
		return forward;
	}

}
