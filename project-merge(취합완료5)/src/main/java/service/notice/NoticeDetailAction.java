package service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class NoticeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDetailAction");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		// 조회수 증가
		dao.readcountUpate(num);
		
		// 상세정보 구하기
		NoticeBean notice = dao.getDetail(num);
		
		// 글 내용 줄 바꿈 설정
		String content = notice.getContent().replace("\n", "<br>");
		
		// 공유 설정
		request.setAttribute("notice", notice);
		request.setAttribute("content", content);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./notice/notice_view.jsp");
		
		return forward;
	}

}
