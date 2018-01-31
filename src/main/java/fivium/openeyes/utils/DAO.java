package fivium.openeyes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAO {

	private static Connection connection;
	private static Log logger = LogFactory.getLog(DAO.class);

	private enum QueryType {
		FETCH, MUTATE
	}

	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null) {
			Class.forName("org.mariadb.jdbc.Driver");
			// 2147483 seconds ~ 24 days (maximum for mysql run on windows)
			connection = DriverManager.getConnection("jdbc:mysql://192.168.57.35:3306/openeyes?user=admin&password=root&sessionVariables=wait_timeout=2147483");
		}
		return connection;
	}

	private static Object executeStatement(String sql, Object[] args, QueryType queryType)
			throws SQLException, ClassNotFoundException {
		
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		// insert args
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
		}

		switch (queryType) {
		case FETCH:
			return preparedStatement.executeQuery();
		case MUTATE:
			return preparedStatement.executeUpdate();
		default:
			return null;
		}

	}

	public static Collection<Map<String, String>> executeFetchStatement(String sql, Object[] args)
			throws SQLException, ClassNotFoundException {

		Collection<Map<String, String>> returnData = new HashSet<Map<String, String>>();
		ResultSet resultSet = (ResultSet) executeStatement(sql, args, QueryType.FETCH);
		ResultSetMetaData md = resultSet.getMetaData();
		int columns = md.getColumnCount();
		while (resultSet.next()) {
			HashMap<String, String> row = new HashMap<String, String>(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), String.valueOf(resultSet.getObject(i)));
			}
			returnData.add(row);
		}
		return returnData;
	}

	public static int executeMutateStatement(String sql, Object[] args)
			throws SQLException, ClassNotFoundException {

		 return (int) executeStatement(sql, args, QueryType.MUTATE);
		
	}


}
