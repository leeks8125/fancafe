
package service.gallery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryListAction");
		
		int page = 1; 		// 현재 페이지 번호
		int limit = 10;     // 한 화면에 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
			
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		int listcount = dao.getCount();		// 총 데이터 갯수
		System.out.println("listcount:"+ listcount);
		
		List<GalleryBean> boardlist = dao.getList();
		System.out.println("boardlist:" + boardlist);
		
		// 총 페이지
		int pageCount=listcount/limit+((listcount%limit==0) ? 0:1); 
		
		int startPage = ((page - 1)/10) * limit + 1; // 1,  11, 21..
		int endPage = startPage + 10 - 1;            // 10, 20, 30..
		
		if(endPage > pageCount)   endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		
		// dispatcher 방식으로 포워딩이 되어야, view 페이지에서 공유한 값에 
		// 접근할수 있다.
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./gallery/Gallery_test.jsp");
		
		return forward;
	}

}
