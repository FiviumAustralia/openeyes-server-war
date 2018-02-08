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
		QUERY_MAP.put("GetAllInjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_QUERY);
		QUERY_MAP.put("GetAllInjectionsMedicinesEyes", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("GetTotalInjections", GET_ALL_INJECTIONS_QUERY);
		QUERY_MAP.put("GetTotalMedications", GET_ALL_MEDICATION);
		QUERY_MAP.put("GetTotalEyes", GET_ALL_EYES);
		QUERY_MAP.put("GetAllPatientsInjections", GET_ALL_PATIENT_INJECTIONS);
		return QUERY_MAP;
	}

	private static final String GET_ALL_PATIENTS_QUERY = "SELECT "
			+ "pat_hos_num \"Hospital Number\" , pat_nhs_num \"NHS Number\", pat_dob \"Date Of Birth\",pat_gender \"Gender\", cont_nick_name \"Preferred Name\", "
			+ "cont_title \"Title\", cont_first_name \"First Name\", cont_last_name \"Last Name\", cont_maiden_name \"Maiden Name\",pat_is_deceased \"Patient Deceased\", "
			+ "pat_date_of_death \"Deceased Date\" FROM _r_u23s4545r200b365x2_2_full_patients";

	private static final String GET_ALL_INJECTIONS_QUERY = "SELECT "
			+ "ex_inj_injection_number \"INJECTION NUMBER\", ex_inj_batch_number \"INJECTION BATCH\", "
			+ "ex_inj_batch_expiry_date  \"INJECTION BATCH EXPIRY\" " + "FROM _r_u23s4545r200b365x2_1_full_injections";

	private static final String GET_ALL_PATIENT_INJECTIONS = "SELECT "
			+ "pat_hos_num Hospital_Number , pat_nhs_num NHS_Number, pat_dob ,pat_gender Gender, cont_nick_name Preferred_Name, cont_title Title, cont_first_name First_Name, "
			+ "cont_last_name Last_Name, cont_maiden_name Maiden_Name,pat_is_deceased Patient_Deceased, pat_date_of_death Deceased_Date, ex_inj_injection_number, ex_inj_batch_number, "
			+ "ex_inj_batch_expiry_date  FROM _r_u23s4545r200b365x2_2_full_patients A LEFT OUTER JOIN _r_u23s4545r200b365x2_1_full_injections B ON A.pat_id = B.ep_patient_id;";
	
	private static final String GET_ALL_INJECTIONS_MEDICATION_QUERY = "SELECT "
			+ "ex_inj_injection_number, ex_inj_batch_number, ex_inj_batch_expiry_date, med_inj_name FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B " + "ON A.ex_inj_drug_id = B.med_inj_id";

	private static final String GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY = "SELECT "
			+ "ex_inj_injection_number, ex_inj_batch_number, ex_inj_batch_expiry_date, med_inj_name, eye_name "
			+ "FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B ON A.ex_inj_drug_id = B.med_inj_id "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_4_full_eyes C " + "ON A.ex_inj_eye_id = C.eye_id";
	
	private static final String GET_ALL_MEDICATION = "SELECT med_inj_name \"Injection Medication\"  from _r_u23s4545r200b365x2_3_full_medications";
	
	private static final String GET_ALL_EYES ="SELECT eye_name \"Eye Right/Left\"  from _r_u23s4545r200b365x2_4_full_eyes";

}
