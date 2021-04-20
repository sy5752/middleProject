package login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import controller.LoginIn;
import service.IMemberInfoService;
import service.MemberInfoServiceImpl;
import vo.MemberInfoVO;

@RequestMapping("login")
@Controller
public class LoginController {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginIn.class);
	
	@RequestMapping(path="process", method=RequestMethod.POST)
	protected String doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		
		
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

		}
		
		return "redirect:/login/view";
		//request.getRequestDispatcher("hotel/loginIn.jsp").forward(request, response);

		
	}

}
