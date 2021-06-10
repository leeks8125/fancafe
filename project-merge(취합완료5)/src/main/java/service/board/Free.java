package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelBean;
import service.Action;
import service.ActionForward;





public class Free implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Free");

		ModelBean mboard = new ModelBean();
		
		mboard.setId("id");
		mboard.setSubject("subject");
		mboard.setContent("content");
		mboard.setReadcount(0);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Boardlistaction.ks");
		
		return forward;
	}

}
