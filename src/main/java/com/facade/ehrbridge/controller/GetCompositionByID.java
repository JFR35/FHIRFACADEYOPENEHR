package com.facade.ehrbridge.controller;

import com.facade.ehrbridge.service.GetCompositionsByEhrId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ehrcomposition")

public class GetCompositionByID {

    private final GetCompositionsByEhrId getCompositionsByEhrId;


    public GetCompositionByID(GetCompositionsByEhrId getCompositionsByEhrId) {
        this.getCompositionsByEhrId = getCompositionsByEhrId;
    }

    @GetMapping("/ehr/{ehrId}")
    public List<String> getCompositionByEhrId(@PathVariable UUID ehrId) {
        System.out.println("Controlador cargado correctamente");
        return getCompositionsByEhrId.getCompositionsEhrId(ehrId.toString());
     }
}
