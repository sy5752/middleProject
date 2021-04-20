package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.IMemberInfoService;
import service.MemberInfoServiceImpl;
import vo.MemberInfoVO;

/**
 * Servlet implementation class LoginIn
 */
@WebServlet("/LoginIn.do")
public class LoginIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginIn.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("doPost");
		HttpSession session = request.getSession();

		String userId = request.getParameter("MEM_ID");
		String userPassword = request.getParameter("MEM_PASS");
		String power = null;

		IMemberInfoService service = MemberInfoServiceImpl.getService();

		MemberInfoVO vo = new MemberInfoVO();

		vo.setMem_id(userId);
		vo.setMem_pass(userPassword);

		vo = service.getMemberInfo(vo);

		if (vo.getPower().equals("0")) {
			session.setAttribute("result", vo);
			logger.debug("沅뚰븳 : {}" , vo.getPower());
			
		}
		
		logger.debug("doPost foward");
		request.getRequestDispatcher("hotel/loginIn.jsp").forward(request, response);

	}

}
