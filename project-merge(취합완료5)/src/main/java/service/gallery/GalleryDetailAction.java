package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryDetailAction");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		
		// 조회수 증가
		dao.readcountUpdate(no);
		
		// 상세정보 구하기
		GalleryBean gallery = dao.getDetail(no);
		
		// 글내용
		String contents= gallery.getContents();
		
		// 공유 설정
		request.setAttribute("contents", contents);
		request.setAttribute("gallery", gallery);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./gallery/GalleryView.jsp");
		
		return forward;
	}

}
