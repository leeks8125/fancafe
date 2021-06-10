package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaDetailAction_1 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaDetailAction_1");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		QnaDAO dao = QnaDAO.getInstance();
		// 조회수 증가
		dao.readcountUpdate(num);
		
		// 상세정보 구하기
		QnaBean qna = dao.getDetail(num);
		
		// 내용 줄 바꿈 설정
		String content = qna.getContent().replace("\n", "<br>");
		
		// 공유 설정
		request.setAttribute("qna", qna);
		request.setAttribute("content", content);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/qna_view_1.jsp");
		
		return forward;
	}

}
