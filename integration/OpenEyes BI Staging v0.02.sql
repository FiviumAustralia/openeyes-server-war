
-- ========================================================================================================
-- Replicate base or federated tables base data copy asap to get consistent dataset (maybe validate too
-- ========================================================================================================

-- {stageowner}.{stageprefix}u{userid}s{sessionid}r{reportinstanceid}b{baseextractsetid}x{executeid}_base_{alias}
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_pat
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_pat SELECT * FROM openeyes.patient
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_pat ADD PRIMARY KEY (id)
;

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_cont
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_cont SELECT * FROM openeyes.contact
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_cont ADD PRIMARY KEY (id)
;


DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_ex_inj
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_ex_inj SELECT * FROM openeyes.et_ophtrintravitinjection_treatment
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_ex_inj ADD PRIMARY KEY (id)
;

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_med_inj
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_med_inj SELECT * FROM openeyes.ophtrintravitinjection_treatment_drug
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_med_inj ADD PRIMARY KEY (id)
;

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_ev
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_ev SELECT * FROM openeyes.event
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_ev ADD PRIMARY KEY (id)
;

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_ep
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_ep SELECT * FROM openeyes.episode
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_ep ADD PRIMARY KEY (id)
;

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_base_eye
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_base_eye SELECT * FROM openeyes.eye
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_base_eye ADD PRIMARY KEY (id)
;


-- ========================================================================================================
-- Generate DATASETS - Full Data (NO restriction WHERE clause)
-- ========================================================================================================

-- {stageowner}.{stageprefix}u{userid}s{sessionid}r{reportinstanceid}b{baseextractsetid}x{executeid}_full_{instanceid}_{dataset}

-- -----------------------------
-- DATASET: Injections
-- -----------------------------

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_full_injections
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_full_injections AS
SELECT 
  ex_inj.id AS ex_inj_id
, "L" ex_inj_eye_code
, ex_inj.event_id AS ex_inj_event_id
, ex_inj.eye_id AS ex_inj_eye_id
, ex_inj.left_pre_antisept_drug_id AS ex_inj_pre_antisept_drug_id
, ex_inj.left_pre_skin_drug_id AS ex_inj_pre_skin_drug_id
, ex_inj.left_pre_ioplowering_required AS ex_inj_pre_ioplowering_required
, ex_inj.left_drug_id AS ex_inj_drug_id
, ex_inj.left_number AS ex_inj_injection_number
, ex_inj.left_batch_number AS ex_inj_batch_number
, ex_inj.left_batch_expiry_date AS ex_inj_batch_expiry_date
, ex_inj.left_injection_given_by_id AS ex_inj_injection_given_by_id
, ex_inj.left_injection_time AS ex_inj_injection_time
, ex_inj.left_post_ioplowering_required AS ex_inj_post_ioplowering_required
, ex_inj.last_modified_user_id AS ex_inj_last_modified_user_id
, ex_inj.last_modified_date AS ex_inj_last_modified_date
, ex_inj.created_user_id AS ex_inj_created_user_id
, ex_inj.created_date AS ex_inj_created_date
, ep.patient_id AS ep_patient_id
FROM openeyes._r_u23s4545r200b365x2_base_ex_inj ex_inj
JOIN openeyes._r_u23s4545r200b365x2_base_ev ev ON ev.id = ex_inj.event_id
JOIN openeyes._r_u23s4545r200b365x2_base_ep ep ON ep.id = ev.episode_id
UNION ALL
SELECT 
  ex_inj.id + 100000000000 AS ex_inj_id
, "R" ex_inj_eye_code
, ex_inj.event_id AS ex_inj_event_id
, ex_inj.eye_id AS ex_inj_eye_id
, ex_inj.right_pre_antisept_drug_id AS ex_inj_pre_antisept_drug_id
, ex_inj.right_pre_skin_drug_id AS ex_inj_pre_skin_drug_id
, ex_inj.right_pre_ioplowering_required AS ex_inj_pre_ioplowering_required
, ex_inj.right_drug_id AS ex_inj_drug_id
, ex_inj.right_number AS ex_inj_injection_number
, ex_inj.right_batch_number AS ex_inj_batch_number
, ex_inj.right_batch_expiry_date AS ex_inj_batch_expiry_date
, ex_inj.right_injection_given_by_id AS ex_inj_injection_given_by_id
, ex_inj.right_injection_time AS ex_inj_injection_time
, ex_inj.right_post_ioplowering_required AS ex_inj_post_ioplowering_required
, ex_inj.last_modified_user_id AS ex_inj_last_modified_user_id
, ex_inj.last_modified_date AS ex_inj_last_modified_date
, ex_inj.created_user_id AS ex_inj_created_user_id
, ex_inj.created_date AS ex_inj_created_date
, ep.patient_id AS ep_patient_id
FROM openeyes._r_u23s4545r200b365x2_base_ex_inj ex_inj
JOIN openeyes._r_u23s4545r200b365x2_base_ev ev ON ev.id = ex_inj.event_id
JOIN openeyes._r_u23s4545r200b365x2_base_ep ep ON ep.id = ev.episode_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_full_injections ADD PRIMARY KEY (ex_inj_id, ex_inj_event_id, ep_patient_id)
;

-- -----------------------------
-- DATASET: Patients
-- -----------------------------

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_2_full_patients
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_2_full_patients AS
SELECT 
  cont.id AS cont_id
, cont.nick_name AS cont_nick_name
, cont.primary_phone AS cont_primary_phone
, cont.title AS cont_title
, cont.first_name AS cont_first_name
, cont.last_name AS cont_last_name
, cont.maiden_name AS cont_maiden_name
, cont.qualifications AS cont_qualifications
, cont.last_modified_user_id AS cont_last_modified_user_id
, cont.last_modified_date AS cont_last_modified_date
, cont.created_user_id AS cont_created_user_id
, cont.created_date AS cont_created_date
, cont.contact_label_id AS cont_contact_label_id
, pat.id AS pat_id
, pat.pas_key AS pat_pas_key
, pat.dob AS pat_dob
, pat.gender AS pat_gender
, pat.hos_num AS pat_hos_num
, pat.nhs_num AS pat_nhs_num
, pat.last_modified_user_id AS pat_last_modified_user_id
, pat.last_modified_date AS pat_last_modified_date
, pat.created_user_id AS pat_created_user_id
, pat.created_date AS pat_created_date
, pat.gp_id AS pat_gp_id
, pat.date_of_death AS pat_date_of_death
, pat.practice_id AS pat_practice_id
, pat.ethnic_group_id AS pat_ethnic_group_id
, pat.contact_id AS pat_contact_id
, pat.archive_no_allergies_date AS pat_archive_no_allergies_date
, pat.archive_no_family_history_date AS pat_archive_no_family_history_date
, pat.archive_no_risks_date AS pat_archive_no_risks_date
, pat.deleted AS pat_deleted
, pat.nhs_num_status_id AS pat_nhs_num_status_id
, pat.is_deceased AS pat_is_deceased
, pat.is_local AS pat_is_local
FROM openeyes._r_u23s4545r200b365x2_base_pat pat
JOIN openeyes._r_u23s4545r200b365x2_base_cont cont ON cont.id = pat.contact_id
;

-- -----------------------------
-- DATASET: Medications
-- -----------------------------

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_3_full_medications
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_3_full_medications AS
SELECT 
  med_inj.id AS med_inj_id
, med_inj.name AS med_inj_name
, med_inj.display_order AS med_inj_display_order
, med_inj.active AS med_inj_active
, med_inj.last_modified_user_id AS med_inj_last_modified_user_id
, med_inj.last_modified_date AS med_inj_last_modified_date
, med_inj.created_user_id AS med_inj_created_user_id
, med_inj.created_date AS med_inj_created_date
FROM openeyes._r_u23s4545r200b365x2_base_med_inj med_inj
;

-- -----------------------------
-- DATASET: Eye
-- -----------------------------

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_4_full_eyes
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_4_full_eyes AS
SELECT 
  eye.id AS eye_id
, eye.name AS eye_name
, eye.display_order AS eye_display_order
, eye.created_user_id AS eye_created_user_id
, eye.last_modified_user_id AS eye_last_modified_user_id
, eye.created_date AS eye_created_date
, eye.last_modified_date AS eye_last_modified_date
FROM openeyes._r_u23s4545r200b365x2_base_eye eye
;

-- ========================================================================================================
-- Generate DATASETS - Restricted (WHERE clause)
-- ========================================================================================================

-- {stageowner}.{stageprefix}u{userid}s{sessionid}r{reportinstanceid}b{baseextractsetid}x{executeid}_cut_{instanceid}_{dataset}

DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_cut_1_injections
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_cut_1_injections AS
SELECT *
FROM _r_u23s4545r200b365x2_1_full_injections full_1_injections
WHERE full_1_injections.ex_inj_drug_id = 5
;

-- ========================================================================================================
-- Generate DATASETS - Aggregate Permutation (NO restriction WHERE clause)
-- ========================================================================================================

-- {stageowner}.{stageprefix}u{userid}s{sessionid}r{reportinstanceid}b{baseextractsetid}x{executeid}_restrict_{instanceid}_{dataset}

-- -----------------------------
-- AGG_MNEMONIC: PAT_MED_INJ_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ex_inj_drug_id
, ep_patient_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_MED_INJ
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_event_id
, cut_1_injections.ep_patient_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_inj 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ex_inj_drug_id
, ep_patient_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_MED_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_eye
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_drug_id
, ep_patient_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_MED
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ep_patient_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_med 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_drug_id
, ep_patient_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_INJ_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ep_patient_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_INJ
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ep_patient_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ep_patient_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_inj 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ep_patient_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ep_patient_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ep_patient_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: PAT
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_pat
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ep_patient_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ep_patient_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_pat 
ADD PRIMARY KEY (
-- Agg Dimensions
  ep_patient_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: MED_INJ_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ex_inj_drug_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: MED_INJ
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_drug_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_inj 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ex_inj_drug_id
)
;


-- -----------------------------
-- AGG_MNEMONIC: MED_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_med_eye
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_drug_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: MED_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_med
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_drug_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_med 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_drug_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: INJ_EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_inj_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_inj_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
, cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_inj_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
, ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: INJ
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_inj 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_inj AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_id
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_id
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_inj 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_id
)
;

-- -----------------------------
-- AGG_MNEMONIC: EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_eye 
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_eye AS
SELECT 
-- Agg Dimensions
  cut_1_injections.ex_inj_eye_code
-- Aggregate DATAPOINTS Only
, MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  cut_1_injections.ex_inj_eye_code
;
ALTER TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_eye 
ADD PRIMARY KEY (
-- Agg Dimensions
  ex_inj_eye_code
)
;

-- -----------------------------
-- AGG_MNEMONIC: EYE
-- -----------------------------
DROP TABLE IF EXISTS openeyes._r_u23s4545r200b365x2_1_agg_injections_none
;
CREATE TABLE openeyes._r_u23s4545r200b365x2_1_agg_injections_none AS
SELECT 
-- Agg Dimensions
-- Aggregate DATAPOINTS Only
  MAX(cut_1_injections.ex_inj_injection_number) maximum_injection_number
, COUNT(DISTINCT ex_inj_id) total_openeyes_injection_notes
FROM openeyes._r_u23s4545r200b365x2_cut_1_injections cut_1_injections
GROUP BY
-- Agg Dimensions
  NULL
;

--  ################################################################################
--  ################################################################################
--  ################################################################################

