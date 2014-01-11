package database;

import java.util.*
import javax.sql.*;

public class RegionDataBase extends AbstractDataBase {

	private Connection conn;
		
	public RegionDataBase(String driver, String sql, String username, String password) {
		conn = connect(driver, sql, username, password);
	}

	@Override
	public String getDatabaseName() {
		return "Region";
	}

	@Override
	public List<String> getDatabaseFields() {
		List<String> list = new List<String>();
		list.add("PARENT_ID");
		list.add("ID");
		list.add("NAME");
		list.add("POPULATION");
		list.add("SQUARE");
		return list;
	}
}