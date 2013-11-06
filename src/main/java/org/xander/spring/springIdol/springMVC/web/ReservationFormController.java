package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.xander.spring.springIdol.springMVC.domain.Player;
import org.xander.spring.springIdol.springMVC.domain.Reservation;
import org.xander.spring.springIdol.springMVC.domain.ReservationValidator;
import org.xander.spring.springIdol.springMVC.domain.SportType;
import org.xander.spring.springIdol.springMVC.service.ReservationService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservationForm")
//helps to save valid entered data at form
@SessionAttributes("reservation")
public class ReservationFormController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationValidator reservationValidator;

    @ModelAttribute("sportTypes")
    public List<SportType> populateSportTypes() {
        return reservationService.getAllSportTypes();
    }

//    http://localhost:8080/reservationForm?username=Roger

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam(required = false, value = "username") String username,
                            Model model) {
        Reservation reservation = new Reservation();
        reservation.setDate(new Date());
        reservation.setPlayer(new Player(username, null));
        model.addAttribute("reservation", reservation);
        return "reservationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("reservation") Reservation reservation,
            BindingResult result, SessionStatus status, Model model) {
        reservationValidator.validate(reservation, result);
        if (result.hasErrors()) {
            model.addAttribute("reservation", reservation);
            return "reservationForm";
        } else {
            reservationService.make(reservation);
            /**
             * Mark the current handler's session processing as complete, allowing for
             * cleanup of session attributes.
             */
            status.setComplete();
            return "redirect:reservationSuccess";
        }
    }


}
