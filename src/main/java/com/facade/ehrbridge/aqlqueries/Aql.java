package com.facade.ehrbridge.aqlqueries;

public class Aql {
    public static final String COMPOSITIONS_BY_EHR_ID =
            "SELECT c/uid/value FROM EHR e CONTAINS COMPOSITION c WHERE e/ehr_id/value = '%s'";
}