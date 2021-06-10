package service.gallery;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryDelete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String check = request.getParameter("check");
		
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		GalleryBean old = dao.getDetail(no);
		
		String path = request.getRealPath("galleryupload");
		System.out.println("path:"+path);
		
		// 아이디 비교
		if (check.equals("지금삭제")) {
			int result = dao.delete(no);
			if(result == 1) System.out.println("삭제 성공");
			
			// 첨부파일이 있을 경우에 첨부파일 삭제
			if(old.getFname() != null) {
				
				File file = new File(path);
				file.mkdir();
				
				// boardupload 디렉토리의 모든 첨부파일 구해오기
				File[] f = file.listFiles();
				for(int i=0; i<f.length; i++) {
					if(f[i].getName().equals(old.getFname())) {
						f[i].delete();
					}
				}
				
			}
		}else {										 // 비번 불일치시
			out.println("<script>");
			out.println("alert('정확히 입력해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/GalleryListAction.dk");
		
		return forward;
	}

}
