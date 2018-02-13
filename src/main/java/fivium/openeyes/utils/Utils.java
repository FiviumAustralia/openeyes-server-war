package fivium.openeyes.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

public class Utils {
	
	private static Log logger = LogFactory.getLog(Utils.class);

	public static void set400Reponse(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.getWriter().write(message);
	}
	
	public static Map<String, Object> parseJsonRequest(HttpServletRequest httpRequest) throws IOException {

		Gson gson = new Gson();
		Map<String, Object> jsonRequestObject = new HashMap<String, Object>();
		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = httpRequest.getReader().readLine()) != null) {
			sb.append(s);
		}
		String json = sb.toString();
		jsonRequestObject = gson.fromJson(json, Map.class);
		return jsonRequestObject;
	}
	
	public static String createJsonErrorResult(String errorMsg) {
		
		Map<String, String> errorResultMap = new HashMap<String, String>();
		errorResultMap.put("error", errorMsg);
		
		return new Gson().toJson(errorResultMap);
		
	}
	
}

