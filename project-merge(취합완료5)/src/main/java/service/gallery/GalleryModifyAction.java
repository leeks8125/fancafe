package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryModifyAction");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");
		
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		GalleryBean gallery = dao.getDetail(no); // 상세 정보 구하기
		
		request.setAttribute("gallery", gallery);	    // 공유 설정
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./gallery/GalleryModify.jsp"); // 수정 폼
		
		return forward;
	}

}
