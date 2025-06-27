package com.facade.ehrbridge.controller;

import com.facade.ehrbridge.service.CreateEhrIdUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ehrcomposition")
public class CreateEhrIdController {

    private final CreateEhrIdUseCase createEhrIdUseCase;


    public CreateEhrIdController(CreateEhrIdUseCase createEhrIdUseCase) {
        this.createEhrIdUseCase = createEhrIdUseCase;
    }

    @PostMapping()
    public ResponseEntity<String> createEhr() {
        String ehrId = String.valueOf(createEhrIdUseCase.createNewEhr());
        return ResponseEntity.ok(ehrId);
    }
}
