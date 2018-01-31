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
		QUERY_MAP.put("GetTotalInjectionsByDrug", GET_TOTAL_INJECTIONS_BY_DRUG);
		QUERY_MAP.put("GetTotalInjectionsByDrugAndPatient", GET_TOTAL_INJECTIONS_BY_DRUG_AND_PATIENT);
		
		return QUERY_MAP;
	}
	
	
	private static final String GET_ALL_PATIENTS_QUERY = "Select * from patient";
	
	private static final String GET_PATIENT_BY_ID = "Select * from patient where id = ?";
	
	private static final String GET_TOTAL_INJECTIONS_BY_DRUG = "SELECT " +
			"  treatment.name drug " +
			", COUNT(*) total_injections " +
			"FROM ( " +
			"SELECT * " +
			"FROM et_ophtrintravitinjection_treatment et_treatment " +
			") i " +
			"JOIN ophtrintravitinjection_treatment_drug treatment " +
			"  ON (treatment.id = i.left_drug_id OR treatment.id = i.right_drug_id) " +
			"GROUP BY " +
			"  treatment.name; ";
					
	private static final String GET_TOTAL_INJECTIONS_BY_DRUG_AND_PATIENT = "SELECT " +
			"  CONCAT(c.first_name, ' ', c.last_name) patient_name " +
			", treatment.name medication " +
			", COUNT(*) total_injections " +
			"FROM ( " +
			"SELECT * " +
			"FROM et_ophtrintravitinjection_treatment et_treatment " +
			") i " +
			"JOIN ophtrintravitinjection_treatment_drug treatment " +
			"  ON (treatment.id = i.left_drug_id OR treatment.id = i.right_drug_id) " +
			"JOIN event e " +
			"  ON e.id = i.event_id " +
			"JOIN episode ep " +
			"  ON ep.id = e.episode_id " +
			"JOIN patient p " +
			"  ON p.id = ep.patient_id " +
			"JOIN contact c " +
			"  ON c.id = p.contact_id " +
			"GROUP BY " +
			"  p.id " +
			", treatment.id ";
					
	
}
