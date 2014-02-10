package action.handlers.university;

import action.*;
import hibernate.dao.*;
import hibernate.logic.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;

public class RemoveUniversity extends GatewayAction {
	
	private static final Logger logger = Logger.getLogger("logger");	

	public void perform(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			logger.info("Prepare to remove university");
			logger.info("Removing university id: " + request.getParameter("id"));
		
			int id = Integer.valueOf(request.getParameter("id"));
			Gateway gateway = getGateway();
			University university = (University) gateway.get(University.class, id);
			gateway.remove(university);
				
			logger.info("University was successfully removed");			
			logger.info("Send redirect to showAllUniversity page");

			response.sendRedirect("/WebPrototype/university/showAll?success=true");
		}
		catch (Exception e) {
			logger.error("Error occured in RemoveUniversity action", e);
		}
	}
}