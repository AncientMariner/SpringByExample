package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.xander.spring.springIdol.springMVC.domain.SportType;
import org.xander.spring.springIdol.springMVC.domain.SportTypeEditor;
import org.xander.spring.springIdol.springMVC.service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationBindingInitializer implements WebBindingInitializer {

    public ReservationBindingInitializer() {
    }

    private ReservationService reservationService;
    @Autowired
    public ReservationBindingInitializer(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
        binder.registerCustomEditor(SportType.class, new SportTypeEditor(
                reservationService));
    }
}
