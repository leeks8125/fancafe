package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;
import service.qna.QnaAddAction;
import service.qna.QnaCheck;
import service.qna.QnaDelete;
import service.qna.QnaDelete_1;
import service.qna.QnaDetailAction;
import service.qna.QnaDetailAction_1;
import service.qna.QnaListAction;
import service.qna.QnaModify;
import service.qna.QnaModifyAction;
import service.qna.QnaReply;
import service.qna.QnaReplyAction;

/**
 * Servlet implementation class QnaController
 */
@WebServlet("*.jy")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;

		// 서블릿
		// 글작성
		if (command.equals("/QnaAddAction.jy")) {
			try {
				action = new QnaAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글작성 폼
		} else if (command.equals("/QnaForm.jy")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/qna/qna_write.jsp");
			
			// 글목록
		} else if (command.equals("/QnaListAction.jy")) {
			try {
				action = new QnaListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글 확인 폼
		} else if (command.equals("/QnaCheckAction.jy")) {
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("/qna/qna_check.jsp");

			// 글 확인
		} else if (command.equals("/QnaCheck.jy")) {
			try {
				action = new QnaCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 상세 페이지
		} else if (command.equals("/QnaDetailAction.jy")) {
			try {
				action = new QnaDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 상세 페이지(관리자)
		} else if (command.equals("/QnaDetailAction_1.jy")) {
			try {
				action = new QnaDetailAction_1();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 댓글 폼
		} else if (command.equals("/QnaReply.jy")) {
			try {
				action = new QnaReply();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 댓글 작성
		} else if (command.equals("/QnaReplyAction.jy")) {
			try {
				action = new QnaReplyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정 폼
		} else if (command.equals("/QnaModifyAction.jy")) {
			try {
				action = new QnaModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정
		} else if (command.equals("/QnaModify.jy")) {
			try {
				action = new QnaModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 삭제 폼(관리자)
		} else if (command.equals("/QnaDeleteAction_1.jy")) {
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("/qna/qna_delete_1.jsp");

			// 삭제(관리자)
		} else if (command.equals("/QnaDelete_1.jy")) {
			try {
				action = new QnaDelete_1();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 삭제 폼
		} else if (command.equals("/QnaDeleteAction.jy")) {
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("/qna/qna_delete.jsp");

			// 삭제
		} else if (command.equals("/QnaDelete.jy")) {
			try {
				action = new QnaDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 포워딩
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response); // 포워딩
			}
		}

	} // doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		doProcess(request, response);
	}

}