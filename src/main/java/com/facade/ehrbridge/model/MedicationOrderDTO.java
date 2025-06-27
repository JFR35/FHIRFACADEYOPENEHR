package com.facade.ehrbridge.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * Basadp en MedicationOrder
 */
public class MedicationOrderDTO {

    @NotBlank
    private String medicationItem; // De medicationItemValue
    @NotBlank
    private String route; // De MedicationOrderRouteElement
    private LocalDateTime startDateTime;
    private LocalDateTime stopDateTime;

    public String getMedicationItem() {
        return medicationItem;
    }

    public void setMedicationItem(String medicationItem) {
        this.medicationItem = medicationItem;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getStopDateTime() {
        return stopDateTime;
    }

    public void setStopDateTime(LocalDateTime stopDateTime) {
        this.stopDateTime = stopDateTime;
    }
}
