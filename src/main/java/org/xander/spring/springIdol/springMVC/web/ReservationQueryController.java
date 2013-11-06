package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xander.spring.springIdol.springMVC.domain.Reservation;
import org.xander.spring.springIdol.springMVC.service.ReservationNotAvailableException;
import org.xander.spring.springIdol.springMVC.service.ReservationService;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {
    private ReservationService reservationService;

    @Autowired
    public void ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm() {
    }

    @RequestMapping(value = "/notSupported", method = RequestMethod.GET)
    public void notSupported() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/notAvailable", method = RequestMethod.GET)
    public void notAvailable() {
        ReservationNotAvailableException reservationNotAvailableException =
                new ReservationNotAvailableException("customCourt", new Date(), Calendar.HOUR_OF_DAY);
        throw reservationNotAvailableException;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        List<Reservation> reservations = Collections.emptyList();
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        model.addAttribute("reservations", reservations);
        return "reservationQuery";
    }
}
