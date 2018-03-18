package fivium.openeyes.utils;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	public static Map<String, String> QUERY_MAP = initQueryMap();
	
	public static Map<String, String> DATABASE_TABLENAME_MAPPING = initTableNameMap();
	
	public static Map<String, String> DATABASE_TABLE_MAPPING = initDatabaseMap();

	private static Map<String, String> initQueryMap() {

		if (QUERY_MAP != null) {
			return QUERY_MAP;
		}
		
		

		QUERY_MAP = new HashMap<String, String>();
		QUERY_MAP.put("Patients", GET_ALL_PATIENTS_QUERY);
		QUERY_MAP.put("Injections", GET_ALL_INJECTIONS_QUERY);
		QUERY_MAP.put("Medications", GET_ALL_MEDICATION);
		QUERY_MAP.put("Eyes", GET_ALL_EYES);
		
		QUERY_MAP.put("PatientsInjections", GET_ALL_PATIENT_INJECTIONS_QUERY);
		QUERY_MAP.put("InjectionsPatients", GET_ALL_PATIENT_INJECTIONS_QUERY);
		
		QUERY_MAP.put("InjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_QUERY);
		QUERY_MAP.put("MedicationsInjections", GET_ALL_INJECTIONS_MEDICATION_QUERY);
		
		// all except patients
		QUERY_MAP.put("InjectionsMedicationsEyes", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("InjectionsEyesMedications", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("EyesMedicationsInjections", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("EyesInjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("MedicationsEyesInjections", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		QUERY_MAP.put("MedicationsInjectionsEyes", GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY);
		
		// all except eyes
		QUERY_MAP.put("InjectionsMedicationsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		QUERY_MAP.put("InjectionsPatientsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		QUERY_MAP.put("PatientsMedicationsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		QUERY_MAP.put("PatientsInjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		QUERY_MAP.put("MedicationsPatientsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		QUERY_MAP.put("MedicationsInjectionsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY);
		
		// all except medications
		QUERY_MAP.put("InjectionsEyesPatients", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		QUERY_MAP.put("InjectionsPatientsEyes", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		QUERY_MAP.put("PatientsEyesInjections", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		QUERY_MAP.put("PatientsInjectionsEyes", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		QUERY_MAP.put("EyesPatientsInjections", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		QUERY_MAP.put("EyesInjectionsPatients", GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY);
		
		// ALL
		QUERY_MAP.put("InjectionsMedicationsPatientsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("InjectionsMedicationsEyesPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("InjectionsPatientsMedicationsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("InjectionsPatientsEyesMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("InjectionsEyesPatientsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("InjectionsEyesMedicationsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsInjectionsPatientsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsInjectionsEyesPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsEyesInjectionsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsEyesPatientsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsPatientsEyesInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("MedicationsPatientsInjectionsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsMedicationsInjectionsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsMedicationsEyesInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsEyesMedicationsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsEyesInjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsInjectionsEyesMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("PatientsInjectionsMedicationsEyes", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesPatientsInjectionsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesPatientsMedicationsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesMedicationsPatientsInjections", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesMedicationsInjectionsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesInjectionsMedicationsPatients", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);
		QUERY_MAP.put("EyesInjectionsPatientsMedications", GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY);

		
		// Agg queries
		QUERY_MAP.put("AggInjectionsEye", GET_AGG_INJECTIONS_EYE_QUERY);
		QUERY_MAP.put("AggInjectionsInj", GET_AGG_INJECTIONS_INJ_QUERY);
		QUERY_MAP.put("AggInjectionsInjEye", GET_AGG_INJECTIONS_INJ_EYE_QUERY);
		QUERY_MAP.put("AggInjectionsMed", GET_AGG_INJECTIONS_MED);
		QUERY_MAP.put("AggInjectionsMedEye", GET_AGG_INJECTIONS_MED_EYE);
		QUERY_MAP.put("AggInjectionsMedInj", GET_AGG_INJECTIONS_MED_INJ);
		QUERY_MAP.put("AggInjectionsMedInjEye", GET_AGG_INJECTIONS_MED_INJ_EYE);
		QUERY_MAP.put("AggInjectionsNone", GET_AGG_INJECTIONS_NONE);
		QUERY_MAP.put("AggInjectionsPat", GET_AGG_INJECTIONS_PAT);
		QUERY_MAP.put("AggInjectionsPatEye", GET_AGG_INJECTIONS_PAT_EYE);
		QUERY_MAP.put("AggInjectionsPatInj", GET_AGG_INJECTIONS_PAT_INJ);
		QUERY_MAP.put("AggInjectionsPatInjEye", GET_AGG_INJECTIONS_PAT_INJ_EYE);
		QUERY_MAP.put("AggInjectionsPatMed", GET_AGG_INJECTIONS_PAT_MED);
		QUERY_MAP.put("AggInjectionsPatMedEye", GET_AGG_INJECTIONS_PAT_MED_EYE);
		QUERY_MAP.put("AggInjectionsPatMedInj", GET_AGG_INJECTIONS_PAT_MED_INJ);
		QUERY_MAP.put("AggInjectionsPatMedInjEye", GET_AGG_INJECTIONS_PAT_MED_INJ_EYE);
		
		
		return QUERY_MAP;
	}

	
	private static Map<String, String> initTableNameMap() {
		
		if (DATABASE_TABLENAME_MAPPING != null) {
			return DATABASE_TABLENAME_MAPPING;
		}
		
		DATABASE_TABLENAME_MAPPING = new HashMap<String, String>();
		DATABASE_TABLENAME_MAPPING.put("Patients", "_r_u23s4545r200b365x2_2_full_patients");
		DATABASE_TABLENAME_MAPPING.put("Medications", "_r_u23s4545r200b365x2_3_full_medications");
		DATABASE_TABLENAME_MAPPING.put("Injections", "_r_u23s4545r200b365x2_1_full_injections");
		DATABASE_TABLENAME_MAPPING.put("Eyes", "_r_u23s4545r200b365x2_4_full_eyes");
		
		return DATABASE_TABLENAME_MAPPING;
	}


	private static Map<String, String> initDatabaseMap() {

		if (DATABASE_TABLE_MAPPING != null) {
			return DATABASE_TABLE_MAPPING;
		}

		DATABASE_TABLE_MAPPING = new HashMap<String, String>();
		DATABASE_TABLE_MAPPING.put("Preferred Name", "cont_nick_name");
		DATABASE_TABLE_MAPPING.put("Title", "cont_title");
		DATABASE_TABLE_MAPPING.put("First Name", "cont_first_name");
		DATABASE_TABLE_MAPPING.put("Last Name", "cont_last_name");
		DATABASE_TABLE_MAPPING.put("Maiden Name", "cont_maiden_name");
		DATABASE_TABLE_MAPPING.put("Date of Birth", "pat_dob");
		DATABASE_TABLE_MAPPING.put("Gender", "pat_gender");
		DATABASE_TABLE_MAPPING.put("Hospital Number", "pat_hos_num");
		DATABASE_TABLE_MAPPING.put("NHS Number", "pat_nhs_num");
		DATABASE_TABLE_MAPPING.put("Deceased Date", "pat_date_of_death");
		DATABASE_TABLE_MAPPING.put("Patient Deceased?", "pat_is_deceased");
		DATABASE_TABLE_MAPPING.put("Injection Number", "ex_inj_injection_number");
		DATABASE_TABLE_MAPPING.put("Injection Batch", "ex_inj_batch_number");
		DATABASE_TABLE_MAPPING.put("Inject Batch Expiry", "ex_inj_batch_expiry_date");
		DATABASE_TABLE_MAPPING.put("Injection Medication", "med_inj_name");
		DATABASE_TABLE_MAPPING.put("Eye Right/Left", "eye_name");

		DATABASE_TABLE_MAPPING.put("Injection Eye Code Aggregate", "ex_inj_eye_code");
		DATABASE_TABLE_MAPPING.put("Injection Eye Code Aggregate", "ex_inj_id");
		DATABASE_TABLE_MAPPING.put("Injection Drug Id Aggregate", "ex_inj_drug_id");
		DATABASE_TABLE_MAPPING.put("Patient Id Aggregate", "ep_patient_id");
		DATABASE_TABLE_MAPPING.put("Maximum Injection Number", "maximum_injection_number");
		DATABASE_TABLE_MAPPING.put("Total Openeyes Injection Notes", "total_openeyes_injection_notes");
		
		return DATABASE_TABLE_MAPPING;
	}

	private static final String GET_ALL_PATIENTS_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_2_full_patients";

	private static final String GET_ALL_INJECTIONS_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections";

	private static final String GET_ALL_PATIENT_INJECTIONS_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_2_full_patients A LEFT OUTER JOIN _r_u23s4545r200b365x2_1_full_injections B ON A.pat_id = B.ep_patient_id;";
	
	private static final String GET_ALL_INJECTIONS_MEDICATION_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B " + "ON A.ex_inj_drug_id = B.med_inj_id";

	
	private static final String GET_ALL_INJECTIONS_MEDICATION_EYES_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B ON A.ex_inj_drug_id = B.med_inj_id "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_4_full_eyes C " + "ON A.ex_inj_eye_id = C.eye_id";
	
	private static final String GET_ALL_INJECTIONS_MEDICATION_PATIENTS_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B ON A.ex_inj_drug_id = B.med_inj_id "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_2_full_patients C " + "ON A.ep_patient_id = C.pat_id";
	
	private static final String GET_ALL_INJECTIONS_EYES_PATIENTS_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_4_full_eyes B ON A.ex_inj_eye_id = B.eye_id "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_2_full_patients C " + "ON A.ep_patient_id = C.pat_id";
	
	
	private static final String GET_ALL_INJECTIONS_MEDICATION_PATIENTS_EYES_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_full_injections A "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_3_full_medications B ON A.ex_inj_drug_id = B.med_inj_id "
			+ "LEFT OUTER JOIN _r_u23s4545r200b365x2_2_full_patients C " + "ON A.ep_patient_id = C.pat_id "
	        + "LEFT OUTER JOIN _r_u23s4545r200b365x2_4_full_eyes D " + "ON A.ex_inj_eye_id = D.eye_id";
	
	private static final String GET_ALL_MEDICATION = "SELECT ? FROM _r_u23s4545r200b365x2_3_full_medications";
	
	private static final String GET_ALL_EYES ="SELECT ? FROM _r_u23s4545r200b365x2_4_full_eyes";
	
	// AGG select queries
	private static final String GET_AGG_INJECTIONS_EYE_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_eye";

	private static final String GET_AGG_INJECTIONS_INJ_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_inj";

	private static final String GET_AGG_INJECTIONS_INJ_EYE_QUERY = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_inj_eye";

	private static final String GET_AGG_INJECTIONS_MED = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_med";

	private static final String GET_AGG_INJECTIONS_MED_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_med_eye";

	private static final String GET_AGG_INJECTIONS_MED_INJ = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_med_inj";

	private static final String GET_AGG_INJECTIONS_MED_INJ_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_med_inj_eye";

	private static final String GET_AGG_INJECTIONS_NONE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_none";

	private static final String GET_AGG_INJECTIONS_PAT = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat";

	private static final String GET_AGG_INJECTIONS_PAT_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_eye";

	private static final String GET_AGG_INJECTIONS_PAT_INJ = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_inj";

	private static final String GET_AGG_INJECTIONS_PAT_INJ_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_inj_eye";

	private static final String GET_AGG_INJECTIONS_PAT_MED = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_med";

	private static final String GET_AGG_INJECTIONS_PAT_MED_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_med_eye";

	private static final String GET_AGG_INJECTIONS_PAT_MED_INJ = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_med_inj";

	private static final String GET_AGG_INJECTIONS_PAT_MED_INJ_EYE = "SELECT ? FROM _r_u23s4545r200b365x2_1_agg_injections_pat_med_inj_eye";

}
