package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaModifyAction");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		QnaDAO dao = QnaDAO.getInstance();
		// 상세 정보
		QnaBean qna = dao.getDetail(num);	
		
		request.setAttribute("qna", qna);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/qna_modify.jsp");
		
		return forward;
	}

}
