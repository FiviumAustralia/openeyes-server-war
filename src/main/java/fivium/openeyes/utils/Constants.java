package fivium.openeyes.utils;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	public static Map<String, String> QUERY_MAP = initQueryMap();

	private static Map<String, String> initQueryMap() {
		
		if (QUERY_MAP != null) {
			return QUERY_MAP;
		}
		
		QUERY_MAP = new HashMap<String, String>();
		
		QUERY_MAP.put("GetAllPatients", GET_ALL_PATIENTS_QUERY);
		QUERY_MAP.put("GetPatientByID", GET_PATIENT_BY_ID);
		
		return QUERY_MAP;
	}
	
	
	private static final String GET_ALL_PATIENTS_QUERY = "Select * from patient";
	private static final String GET_PATIENT_BY_ID = "Select * from patient where id = ?";
	
}
