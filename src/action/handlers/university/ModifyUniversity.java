package action.handlers.university;

import action.*;
import hibernate.dao.*;
import hibernate.logic.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;

public class ModifyUniversity implements HttpAction {

	private static final Logger logger = Logger.getLogger(ModifyUniversity.class);	
	
	public void perform(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			logger.info("Prepare to modify university");

			int id = Integer.valueOf(request.getParameter("id"));
			University university = new University();
			university.setName(request.getParameter("name"));
			university.setDepartamentsCount(Integer.valueOf(request.getParameter("departs_count")));
			university.setWWW(request.getParameter("www"));
			university.setParentID(Integer.valueOf(request.getParameter("parent_id")));	
		
			logger.info("New university properties: ");
			logger.info("Name: " + request.getParameter("name"));
			logger.info("DepartamentsCount: " + request.getParameter("departs_count"));
			logger.info("WWW: " + request.getParameter("www"));
			logger.info("ParentID: " + request.getParameter("parent_id"));

			GatewayResolver.getGateway().modify(id, university);

			logger.info("University was successfully modified");			
			logger.info("Send redirect to showAllUniversity page");

			response.sendRedirect("/WebPrototype/university/showAll.jsp?success=true");
		}
		catch (Exception e) {
			logger.error("Error occured in ModifyUniversity action", e);
		}
	}
}