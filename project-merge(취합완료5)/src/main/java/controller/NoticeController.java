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
import service.notice.NoticeAddAction;
import service.notice.NoticeDelete;
import service.notice.NoticeDetailAction;
import service.notice.NoticeListAction;
import service.notice.NoticeModify;
import service.notice.NoticeModifyAction;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("*.sh")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 서블릿
		// 글 작성
		if (command.equals("/NoticeAddAction.sh")) {
			try {
				action = new NoticeAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 글 작성 폼
		} else if (command.equals("/NoticeForm.sh")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/notice/notice_write.jsp");
		
		// 글 목록
		} else if (command.equals("/NoticeListAction.sh")) {
			try {
				action = new NoticeListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 상세 페이지
		} else if (command.equals("/NoticeDetailAction.sh")) {
			try {
				action = new NoticeDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 수정 폼
		} else if (command.equals("/NoticeModifyAction.sh")) {
			try {
				action = new NoticeModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 글 수정
		} else if (command.equals("/NoticeModify.sh")) {
			try {
				action = new NoticeModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 글 삭제 폼
		} else if (command.equals("/NoticeDeleteAction.sh")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/notice/notice_delete.jsp");
		
		// 글 삭제
		} else if (command.equals("/NoticeDelete.sh")) {
			try {
				action = new NoticeDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} // if end
		
		// 포워딩
		if(forward != null) {
			if(forward.isRedirect()) {	// redirect 방식
				response.sendRedirect(forward.getPath());
			} else {					// dispatcher 방식
				RequestDispatcher dispatcher = 
							request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);	// 포워딩
			}
		}
		
	}	// doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		
		doProcess(request, response);
	}

}
