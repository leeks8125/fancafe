package service.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import model.ModelBean;
import service.Action;
import service.ActionForward;

public class Boardmodify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("Boardmodify");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String myid = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		
		ModelBean mboard = new ModelBean();
		mboard.setNum(num);
		mboard.setId(request.getParameter("id"));
		mboard.setSubject(request.getParameter("subject"));
		mboard.setContent(request.getParameter("content"));
		
		BoardDao dao = BoardDao.getInstance();
		
		if(id.equals(myid)) { 
			int result = dao.update(mboard);
			if(result==1) {
				System.out.println("수정 성공");
			}
		}else {										
			out.println("<script>");
			out.println("alert('수정실패.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
					
			return null;
		}		
				
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Boarddetailaction.ks?num="+num+"&page="+page);
				
		return forward;
	}

}
