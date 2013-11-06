package org.xander.spring.springIdol.springMVC.domain;

import org.xander.spring.springIdol.springMVC.service.ReservationService;

import java.beans.PropertyEditorSupport;

public class SportTypeEditor extends PropertyEditorSupport {

    private ReservationService reservationService;

    public SportTypeEditor(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    public void setAsText(String text) throws IllegalArgumentException {
        int sportTypeId = Integer.parseInt(text);
        SportType sportType = reservationService.getSportType(sportTypeId);
        setValue(sportType);
    }

}
