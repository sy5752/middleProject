package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IReviewService;
import service.ReviewServiceImpl;
import vo.ReviewVO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/ReviewUpdate2.do")
public class ReviewUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
//		String writer = request.getParameter("writer");
		String rev_title = request.getParameter("rev_title");
//		String mail = request.getParameter("mail");
//		String password = request.getParameter("password");
		String rev_cont = request.getParameter("rev_cont");
		int rev_no = Integer.parseInt(request.getParameter("rev_no"));
		
//		MemberInfoVO vo1 = (MemberInfoVO) session.getAttribute("result");
//		String mem_id = vo1.getMem_id();
		
		//0. writer, subject, mail, password, content, seq
		// 가져와서 BoardVO에 저장
		ReviewVO vo = new ReviewVO();
//		vo.setWriter(writer);
		vo.setRev_title(rev_title);
//		vo.setMail(mail);
//		vo.setPassword(password);
		vo.setRev_cont(rev_cont);;
		vo.setRev_no(rev_no);
//		vo.setMem_id(mem_id);
		
		
		//1
		IReviewService service = ReviewServiceImpl.getService();
		//2
		int cnt = service.updateReview2(vo);
		//3
		request.setAttribute("res", cnt);
		//4
		request.getRequestDispatcher("hotel/result.jsp").forward(request, response);
	}

}
