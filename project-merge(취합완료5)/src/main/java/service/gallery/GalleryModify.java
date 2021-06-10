package service.gallery;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryModify");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String author = request.getParameter("author");
		
		GalleryBean gallery = new GalleryBean();
		gallery.setNo(no);
		gallery.setTitle(request.getParameter("title"));
		gallery.setContents(request.getParameter("contents"));
		
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		GalleryBean old = dao.getDetail(no);
		
		// 아이디 비교
		if (old.getAuthor().equals(author)) {
			int result = dao.update(gallery);
			
			if (result == 1) {
				System.out.println("글 수정 성공");
			}
		} else {
			out.println("<script>");
			out.println("alert('작성자가 일치하지 않습니다')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/GalleryDetailAction.dk?no="+no);
		
		return forward;
	}

}
