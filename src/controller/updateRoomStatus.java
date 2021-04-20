package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.HotelServiceImpl;
import service.IHotelService;

/**
 * Servlet implementation class updateRoomStatus
 */
@WebServlet("/updateRoomStatus.do")
public class updateRoomStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(updateRoomStatus.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String roomPl = request.getParameter("room_pl");
		String roomNo = request.getParameter("room_no");
		String roomType = request.getParameter("room_type");
		String roomStatus = request.getParameter("room_status");
		
		IHotelService service = HotelServiceImpl.getService();
		
		if(roomPl.equals("본점")) {
			roomPl = "headroominfo";
		} else if(roomPl.equals("하와이")) {
			roomPl = "hawaiiroominfo";
		} else {
			roomPl = null;
		}
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("room_pl", roomPl);
		map.put("room_no", roomNo);
		map.put("room_status", roomStatus);
		
//		logger.debug("room_pl : " + map.get("room_pl"));
//		logger.debug("room_no : " + map.get("room_no"));
//		logger.debug("room_status : " + map.get("room_status"));
		logger.debug("room_pl : {}" , map.get("room_pl"));
		logger.debug("room_no : {}" , map.get("room_no"));
		logger.debug("room_status : {}" , map.get("room_status"));
		int res = service.updateRoomStatus(map);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("hotel/result.jsp").forward(request, response);
		
		
	}

}
