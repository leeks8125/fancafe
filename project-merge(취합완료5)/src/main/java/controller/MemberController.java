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
import service.member.IdCheck;
import service.member.Login;
import service.member.MemberInsert;
import service.member.Mypage;
import service.member.QuitMember;
import service.member.QuitMemberOperation;
import service.member.SearchIdOperation;
import service.member.SearchPassOperation;
import service.member.UpdateInsert;
import service.member.UpdateMyinfo;
import service.member.UpdateMypass;
import service.member.UpdateMypassInsert;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.yw")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:"+requestURI);
		System.out.println("contextPate:"+contextPath);
		System.out.println("command:"+command);
		
		Action action = null;
		ActionForward forward = null;
		
		
		
		
		
		//회원가입
		if(command.equals("/MemberInsert.yw")) {
			try {
				action = new MemberInsert();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 아이디 중복검사(아작스)	
		}else if(command.equals("/IdCheck.yw")) {
			try {
				action = new IdCheck();
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원가입 폼으로 이동	
		}else if(command.equals("/MemberForm.yw")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/memberform.jsp");
			
		// 로그인 폼으로 이동	
		}else if(command.equals("/LoginForm.yw")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/loginform.jsp");
			
		//로그인	
		}else if(command.equals("/Login.yw")) {
			try {
				action = new Login();
				forward = action.execute(request, response);	
			}catch(Exception e) {
				e.printStackTrace();
		}
			
		//메인페이지로 이동	
		}else if(command.equals("/Main.yw")) {
			  forward = new ActionForward();
			  forward.setRedirect(false); 
			  forward.setPath("/common/main.jsp");
		
	    // 마이페이지
		}else if(command.equals("/Mypage.yw")) {
			try {
				action = new Mypage();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 로그아웃 이동
		}else if(command.equals("/Logout.yw")) {
			  forward = new ActionForward();
			  forward.setRedirect(false); 
			  forward.setPath("/member/logout.jsp");		
		
		// 내정보 수정으로 이동(내정보값 가지고 이동)	  
		}else if(command.equals("/UpdateMyinfo.yw")) {
			try {
				action = new UpdateMyinfo();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 정보 수정
		}else if(command.equals("/UpdateInsert.yw")) {
			try {
				action = new UpdateInsert();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원탈퇴폼으로 이동(내정보값 가지고 이동)
		}else if(command.equals("/QuitMember.yw")) {
			try {
				action = new QuitMember();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 회원 탈퇴(상태값 1로 변경)	
		}else if(command.equals("/QuitMemberOperation.yw")) {
			try {
				action = new QuitMemberOperation();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 내비번 수정으로 이동(내 정보값 가지고 이동)	
		}else if(command.equals("/UpdateMypass.yw")) {
			try {
				action = new UpdateMypass();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 비번수정	
		}else if(command.equals("/UpdateMypassInsert.yw")) {
			try {
				action = new UpdateMypassInsert();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 아이디찾기 폼으로 이동	
		}else if(command.equals("/SearchId.yw")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/searchidform.jsp");
			
		// 비밀번호 찾기 폼으로 이동	
		}else if(command.equals("/SearchPass.yw")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/searchpassform.jsp");
			
		// 아이디 찾기	
		}else if(command.equals("/SearchIdOperation.yw")) {
			try {
				action = new SearchIdOperation();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 비밀번호 찾기	
		}else if(command.equals("/SearchPassOperation.yw")) {
			try {
				action = new SearchPassOperation();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 뒤로 돌아가기	
		}else if(command.equals("/Back.yw")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/back.jsp");
		
		}
		
		
		
		
		
		// forwarding 처리
		if(forward != null) {
			if(forward.isRedirect()) {	// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else {					// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}  // doProcess() end
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get");
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		
		doProcess(request, response);
	}

}
