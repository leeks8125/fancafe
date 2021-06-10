package service.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import model.NoticeBean;
import service.Action;
import service.ActionForward;

public class NoticeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeListAction");
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		NoticeDAO dao = NoticeDAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount:"+ listcount);
		
		List<NoticeBean> noticelist = dao.getList(startRow, endRow);
		System.out.println("noticelist :"+ noticelist);
		
		// 총 페이지
		int pageCount = (listcount + limit - 1) / limit;
		
		int startPage = ((page -1)/limit) * limit + 1;
		int endPage = startPage +limit - 1;
		
		// 초과 페이지 제거
		if(endPage > pageCount) endPage = pageCount;
		
		// request 공유
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("noticelist", noticelist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./notice/notice_list.jsp");
		
		return forward;
	}

}
