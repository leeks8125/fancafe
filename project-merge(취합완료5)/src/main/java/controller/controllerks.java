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
import service.board.Boardaction;
import service.board.Boarddelete;
import service.board.Boarddetailaction;
import service.board.Boardlistaction;
import service.board.Boardmodify;
import service.board.Boardmodifyaction;
import service.board.Free;
import service.reboard.Boardreply;
import service.reboard.Boardreplyaction;
import service.reboard.Boardreplydelete;
import service.reboard.Boardreplymodify;
import service.reboard.Boardreplymodifyaction;

/**
 * Servlet implementation class MainController
 */
@WebServlet("*.ks")
public class controllerks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI); // /model2/BoardAddAction.do
		System.out.println("contextPath:" + contextPath);// /model2
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/Free.ks")) {
			try {
				action = new Free();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글작성 폼
		} else if (command.equals("/write.ks")) {
			System.out.println("write");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/board/board_write.jsp");
			// 글작성
		} else if (command.equals("/Boardaction.ks")) {
			try {
				System.out.println("Boardaction");
				action = new Boardaction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 글목록
		else if (command.equals("/Boardlistaction.ks")) {
			try {
				System.out.println("Boardlistaction");
				action = new Boardlistaction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
			// 상세 페이지
		 else if (command.equals("/Boarddetailaction.ks")) {
			try {
				action = new Boarddetailaction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 삭제 폼
		} else if (command.equals("/Boarddeleteaction.ks")) {
			System.out.println("Boarddeleteaction");
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("./board/board_delete.jsp");

			// 댓글삭제 폼
		}else if (command.equals("/Boardreplydeleteaction.ks")) {
			System.out.println("Boardreplydeleteaction");
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("./reboard/reboard_replydelete.jsp");

			//댓글수정폼
		} else if (command.equals("/Boardreplymodifyaction.ks")) {
			System.out.println("Boardreplymodifyaction");
			try {
				action = new Boardreplymodifyaction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}

		//댓글수정
		} else if (command.equals("/Boardreplymodify.ks")) {
			try {
				action = new Boardreplymodify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		} 
		
		// 삭제
		else if (command.equals("/Boarddelete.ks")) {
			try {
				action = new Boarddelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글삭제
		}else if (command.equals("/Boardreplydelete.ks")) {
			try {
				
				action = new Boardreplydelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 수정 폼
		} else if (command.equals("/Boardmodifyaction.ks")) {
			try {
				action = new Boardmodifyaction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 수정
		} else if (command.equals("/Boardmodify.ks")) {
			try {
				action = new Boardmodify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 폼
		} else if (command.equals("/Boardreplyaction.ks")) {
			try {
				action = new Boardreplyaction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 댓글 작성
		} else if (command.equals("/Boardreply.ks")) {
			try {
				action = new Boardreply();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

		// forwarding 처리
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
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
		System.out.println("Get");

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
