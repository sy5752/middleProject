<%@page import="vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<RoomVO> list = (List<RoomVO>) request.getAttribute("list");
%>
[
	<%
	for(int i=0; i < list.size(); i++) {
	
		RoomVO vo = list.get(i);
		if(i > 0) out.print(",");
	%>
			{
				"room_no" : "<%= vo.getRoom_no() %>",
				"room_pl" : "<%= vo.getRoom_pl() %>",
				"room_type" : "<%= vo.getRoom_type() %>",
				"room_status" : "<%= vo.getRoom_status() %>"
			}
	<%		
		}
	%>
]













