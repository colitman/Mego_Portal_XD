package action.handlers.university;

import logger.*;
import action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.beans.factory.*;
import org.apache.log4j.*;
import hibernate.dao.*;
import hibernate.logic.*;

public class ShowOneUniversity implements HttpAction {

	private static final Logger logger = Logger.getLogger(ShowOneUniversity.class);	
	
	public String perform(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			logger.info("Prepare to show university");

			int id = Integer.valueOf(request.getParameter("parent_id"));

			Gateway<University> gateway = GatewayResolver.getGateway();
			University university = gateway.get(University.class, id);
	
			logger.info("University properties: ");
	
			LoggerUtils.info(logger, "Name:", university.getName());
			LoggerUtils.info(logger, "DepartamentsCount:", String.valueOf(university.getDepartamentsCount()));
			LoggerUtils.info(logger, "WWW:", university.getWWW());
			LoggerUtils.info(logger, "ParentID:", String.valueOf(university.getParentID()));	
	
			request.setAttribute("parent", university);

			logger.info("Set university into session");
			logger.info("Send redirect to showAllUniversity page");	

			return "university/showOne.jsp";
		}
		catch (Exception e) {
			logger.error("Error occured in ShowOneUniversity action", e);
		}
		return null;
	}
}