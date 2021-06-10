package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaReply implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaReply");
		System.out.println("QnaReply num:"+request.getParameter("num"));
		
		
		request.setCharacterEncoding("utf-8");  // 한글 인코딩
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaBean qna = dao.getDetail(num);   // 상세 정보 구하기
		System.out.println("ref:"+qna.getBoard_re_ref());
		
			
		request.setAttribute("qna", qna);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/qna_reply.jsp");
		
		return forward;
	}

}
