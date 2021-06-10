package service.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.AdminBean;
import service.Action;
import service.ActionForward;

public class AdminDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminDetailAction");
		
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		
		AdminDAO dao = AdminDAO.getInstance();
		AdminBean member = dao.getDetail(id);
		
		// 공유 설정
		request.setAttribute("member", member);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./admin/admin_member_view.jsp");
		
		return forward;
	}

}
