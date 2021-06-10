package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaAddAction");
		
		request.setCharacterEncoding("utf-8");
		
		QnaBean qna = new QnaBean();
		qna.setId(request.getParameter("id"));
		qna.setPasswd(request.getParameter("passwd"));
		qna.setSubject(request.getParameter("subject"));
		qna.setContent(request.getParameter("content"));
		
		QnaDAO dao = QnaDAO.getInstance();
		int result = dao.insert(qna);

		if(result == 1) {
			System.out.println("글작성 성공");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./QnaListAction.jy");
		
		return forward;
	}

}
