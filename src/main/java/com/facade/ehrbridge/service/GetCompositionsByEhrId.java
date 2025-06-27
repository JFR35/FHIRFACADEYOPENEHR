package com.facade.ehrbridge.service;

import java.util.List;

public interface GetCompositionsByEhrId {

    List<String> getCompositionsEhrId(String ehrId);

}
