package service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.AdminBean;
import service.Action;
import service.ActionForward;

public class AdminListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminListAction");
		
		int page = 1;
		int limit = 20;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		AdminDAO dao = AdminDAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount:"+ listcount);
		
		List<AdminBean> memberlist = dao.getList(startRow, endRow);
		System.out.println("memberlist :"+ memberlist);
		
		// 총 페이지
		int pageCount = (listcount + limit - 1) / limit;
		
		int startPage = ((page -1)/limit) * limit + 1;
		int endPage = startPage +limit - 1;
		
		// 초과 페이지 제거
		if(endPage > pageCount) endPage = pageCount;
		
		// request 공유
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("memberlist", memberlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./admin/admin_member_list.jsp");
		
		return forward;
	}

}
