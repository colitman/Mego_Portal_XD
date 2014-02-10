package action.handlers.country;

import action.*;
import hibernate.dao.*;
import hibernate.logic.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;

public class RemoveCountry extends GatewayAction {
		
	private static final Logger logger = Logger.getLogger("logger");		

	public void perform(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			logger.info("Prepare to remove country");
			logger.info("Removing country id: " + request.getParameter("id"));

			int id = Integer.valueOf(request.getParameter("id"));
			Gateway<Country> gateway = getGateway();
			Country country = gateway.get(Country.class, id);
			gateway.remove(country);

			logger.info("Country was successfully removed");			
			logger.info("Send redirect to showAllCountry page");

			response.sendRedirect("/WebPrototype/country/showAll.jsp?success=true");
		}
		catch (Exception e) {
			logger.error("Error occured in RemoveCountry action", e);
		}
	}
}