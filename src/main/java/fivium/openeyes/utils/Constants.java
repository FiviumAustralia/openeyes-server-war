package fivium.openeyes.utils;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	public static Map<String, String> QUERY_MAP = getQueryMap();

	private static Map<String, String> getQueryMap() {
		
		if (QUERY_MAP != null) {
			return QUERY_MAP;
		}
		
		QUERY_MAP = new HashMap<String, String>();
		
		QUERY_MAP.put("GetAllPatients", GET_ALL_PATIENTS_QUERY);
		QUERY_MAP.put("GetPatientByID", GET_PATIENT_BY_ID);
		
		return QUERY_MAP;
	}
	
	
	public static final String GET_ALL_PATIENTS_QUERY = "Select * from patient";
	public static final String GET_PATIENT_BY_ID = "Select * from patient where id = ?";
	
}
