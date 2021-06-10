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
import service.gallery.*;

/**
 * Servlet implementation class GalleryController
 */
@WebServlet("*.dk")
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:"+ requestURI);  // /model2/GalleryAddAction.dk
		System.out.println("contextPath:"+ contextPath);// /model2
		System.out.println("command:"+ command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 글작성
		if(command.equals("/GalleryAddAction.dk")) {
			try {
				action = new GalleryAddAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 글작성 폼	
		}else if(command.equals("/GalleryForm.dk")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./gallery/GalleryWrite.jsp");
			
		// 글목록	
		}else if(command.equals("/GalleryListAction.dk")) {
			try {
				action = new GalleryListAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 상세 페이지	
		}else if(command.equals("/GalleryDetailAction.dk")) {
			try {
				action = new GalleryDetailAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 수정 폼	
		}else if(command.equals("/GalleryModifyAction.dk")) {
			try {
				action = new GalleryModifyAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 수정	
		}else if(command.equals("/GalleryModify.dk")) {
			try {
				action = new GalleryModify();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 삭제 폼	
		}else if(command.equals("/GalleryDeleteAction.dk")) {
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("./gallery/GalleryDelete.jsp");
		
		// 삭제
		}else if(command.equals("/GalleryDelete.dk")) {
			try {
				action = new GalleryDelete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// forwarding 처리
		if(forward != null) {
			if(forward.isRedirect()) {	// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {						// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}			
		}		
		
	} // doProcess() end	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TOdk Auto-generated method stub
		System.out.println("get");
	
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TOdk Auto-generated method stub
		System.out.println("post");
		
		doProcess(request, response);
	}
}