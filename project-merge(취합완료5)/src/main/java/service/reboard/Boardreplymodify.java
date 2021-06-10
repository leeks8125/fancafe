package service.reboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import model.RemodelBean;
import service.Action;
import service.ActionForward;

public class Boardreplymodify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("Boardreplymodify");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String myid =(String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		RemodelBean rmboard = new RemodelBean();
		rmboard.setNum(num);
		rmboard.setId(id);
		rmboard.setContent(request.getParameter("content"));
		rmboard.setRe_seq(re_seq);
		System.out.println("re:"+re_seq);
		
		BoardDao dao = BoardDao.getInstance();
		RemodelBean old = dao.getDetailre(num,re_seq);
		
		
		if(myid.equals(id)) { 
			int result = dao.updatere(rmboard);
			if(result==1) {
				System.out.println("댓글 수정 성공");
			}
		}else {										
			out.println("<script>");
			out.println("alert('댓글 수정 실패.');");
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
