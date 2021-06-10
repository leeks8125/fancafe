package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryDAO_test;
import model.GalleryBean;
import service.Action;
import service.ActionForward;

public class GalleryAddAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GalleryAddAction");
				
		String path = request.getRealPath("galleryupload");
		System.out.println("path:"+path);
		
		int size = 5 * 1024 * 1024;		// 5MB
		
		MultipartRequest multi = 
			new MultipartRequest(request,
								 path,	    // 업로드 디렉토리
								 size,      // 업로드 파일크기(5MB)
								 "utf-8",   // 한글 인코딩
			 new DefaultFileRenamePolicy());// 중복파일 문제 해결
		
		
		
		GalleryBean board = new GalleryBean();
		board.setTitle(multi.getParameter("title"));
		board.setAuthor(multi.getParameter("author"));
		board.setContents(multi.getParameter("contents"));
		board.setFname(multi.getFilesystemName("fname"));  // 첨부파일
		
		GalleryDAO_test dao = GalleryDAO_test.getInstance();
		int result = dao.insert(board);
		if(result == 1) {
			System.out.println("글작성 성공");
		}		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./GalleryListAction.dk");
		
		return forward;
	}

}
