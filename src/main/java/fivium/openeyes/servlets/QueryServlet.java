package fivium.openeyes.servlets;

import static fivium.openeyes.utils.Constants.DATABASE_TABLE_MAPPING;
import static fivium.openeyes.utils.Constants.QUERY_MAP;
import static fivium.openeyes.utils.Constants.DATABASE_TABLE_MAPPING;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import fivium.openeyes.utils.DAO;
import fivium.openeyes.utils.Utils;

public class QueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	
	private static final List<String> VALID_CONTENT_TYPES = Arrays.asList(
			"application/json", 
			"application/json;charset=UTF-8"
			);  
	
	private static Log logger = LogFactory.getLog(QueryServlet.class);
	
	private Map<String, Object> jsonRequestObject = null;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponseresponse)
	 */
	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object queryResult = null;
		
		try {
		
			// validate request
			if (!isValidRequest(request, response)) {
				return;
			}
			
			String queryAction = (String) jsonRequestObject.get("queryAction");
			Map<String, List<String>> query = new HashMap<String, List<String>>();
			query = new Gson().fromJson(queryAction, Map.class);
			String selectedColumns = findSelectedColumns(query);
			String queryToExecute = createSQLQuery(query, selectedColumns);
			if(null == queryToExecute || "".equalsIgnoreCase(queryToExecute)){
				Utils.set400Reponse(response, "Query is not implemented.");
				return;
			}
			
			List<Object> queryList = (List<Object>) jsonRequestObject.get("queryParams");			
			Object[] queryParams = queryList.toArray(new Object[queryList.size()]);
			String queryType = (String) jsonRequestObject.get("queryType");
			
			
			if (queryType.equals("Fetch")) {
				queryResult = DAO.executeFetchStatement(queryToExecute, queryParams);
			} else {
				queryResult = DAO.executeMutateStatement(QUERY_MAP.get(queryAction), queryParams);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Unexpeted error: ", e);
			queryResult = Utils.createJsonErrorResult("Server failed to retrieve data");
		}
		
		String jsonResult = new Gson().toJson(queryResult);
		response.getWriter().write(jsonResult);
	}
	

	private String createSQLQuery(Map<String, List<String>> query, String selectedColumns) {
		Set<String> aSet = query.keySet();
		StringBuilder sb = new StringBuilder();
		for(String key : aSet) {
				sb.append(key);
		}
		try {
			String queryToExecute = QUERY_MAP.get(sb.toString());
			return queryToExecute.replace("?", selectedColumns);
		} catch (Exception e) {
			return "";
		}
	}


	private String findSelectedColumns(Map<String, List<String>> query) {
		StringBuilder sb = new StringBuilder();

		List<String> aSet = new ArrayList<>(query.keySet());
		Collections.sort(aSet, Collections.reverseOrder());
		int i=1;
		for(String key : aSet) {
			ArrayList<String> aList = (ArrayList<String>) query.get(key);
			for(String selectedColumn : aList) {
				sb.append(DATABASE_TABLE_MAPPING.get(selectedColumn));
				sb.append(" \""+selectedColumn+"("+i+")\"");
				sb.append(", ");
			}
			i++;
		}
		return sb.toString().substring(0, sb.toString().length()-2);
	}


	private boolean isValidRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// if request isn't a POST the return a 400 error
		if (!request.getMethod().equals("POST")) {
			Utils.set400Reponse(response, "Invalid Request, " + request.getMethod() + " requests are not allowed.");
			return false;
		}
		
		// if the content type of the request isn't "application/json" OR "application/json; charset=utf-8" then return a 400 error
		if (! VALID_CONTENT_TYPES.contains(request.getContentType())  ) {
			Utils.set400Reponse(response, "Invalid Request, " + request.getContentType() + " requests are not allowed");
			return false;
		}
		
		// if JSON request parsing fails then return a 400 error.  Otherwise, set the graphQL_Query local variable 
		jsonRequestObject = Utils.parseJsonRequest(request);
		if (jsonRequestObject == null) {
			Utils.set400Reponse(response, "Invalid Request, failed to parse JSON request.");
			return false;
		} 
		
		// if given queryAction doesn't exist then return 400 error
//		if (!QUERY_MAP.containsKey(jsonRequestObject.get("queryAction"))) {
//			Utils.set400Reponse(response, "Invalid Request, queryAction '" + jsonRequestObject.get("queryAction") + "' is not implemented.");
//			return false;
//		}
		
		return true;
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      Implemented here as final to prevent subclasses overriding this method
	 */
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
}
