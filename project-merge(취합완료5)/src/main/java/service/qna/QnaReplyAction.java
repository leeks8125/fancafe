package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import model.QnaBean;
import service.Action;
import service.ActionForward;

public class QnaReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("QnaReplyAction");
		System.out.println("QnaReplyAction num:"+request.getParameter("num"));
		System.out.println("QnaReplyAction board_re_ref:"+request.getParameter("board_re_ref"));
		System.out.println("QnaReplyAction board_re_lev:"+request.getParameter("board_re_lev"));
		System.out.println("QnaReplyAction board_re_seq:"+request.getParameter("board_re_seq"));
		System.out.println("QnaReplyAction id:"+request.getParameter("id"));
		System.out.println("QnaReplyAction page:"+request.getParameter("page"));
		System.out.println("QnaReplyAction passwd:"+request.getParameter("passwd"));
		System.out.println("QnaReplyAction subject:"+request.getParameter("subject"));
		System.out.println("QnaReplyAction content:"+request.getParameter("content"));
		
		int num = Integer.parseInt(request.getParameter("num"));
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_lev  = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_seq  = Integer.parseInt(request.getParameter("board_re_seq"));
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		
		QnaBean board = new QnaBean();
		board.setBoard_re_ref(board_re_ref);;
		board.setBoard_re_lev(board_re_lev);
		board.setBoard_re_seq(board_re_seq);
		board.setNum(num);
		board.setId(id);
		board.setPasswd(request.getParameter("passwd"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		QnaDAO dao = QnaDAO.getInstance();
		int result = dao.qnaReply(board); // 답글 작성
	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);   // dispatcher 방식으로 포워딩
		forward.setPath("/QnaListAction.jy?page=" + page); //답글 폼
		
		return forward;
	}

}
																			
