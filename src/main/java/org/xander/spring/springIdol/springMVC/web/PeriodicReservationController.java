package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;
import org.xander.spring.springIdol.springMVC.domain.PeriodicReservation;
import org.xander.spring.springIdol.springMVC.domain.PeriodicReservationValidator;
import org.xander.spring.springIdol.springMVC.domain.Player;
import org.xander.spring.springIdol.springMVC.service.ReservationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/periodicReservationForm")
@SessionAttributes("reservation")
public class PeriodicReservationController {
    private ReservationService reservationService;


    @Autowired
    public PeriodicReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Autowired
    private PeriodicReservationValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        PeriodicReservation reservation = new PeriodicReservation();
        reservation.setPlayer(new Player());
        reservation.setFromDate(new Date());
        model.addAttribute("reservation", reservation);
        return "reservationCourtForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("reservation") PeriodicReservation reservation,
            BindingResult result,
            SessionStatus status,
            //RequestParam("_cancel") String cancelButton.
            @RequestParam("_page") int currentPage,
            Model model) {
        Map pageForms = new HashMap();
        pageForms.put(0, "reservationCourtForm");
        pageForms.put(1, "reservationTimeForm");
        pageForms.put(2, "reservationPlayerForm");
        if (request.getParameter("_cancel") != null) {
            // Return to current page view, since user clicked cancel
            return (String) pageForms.get(currentPage);
        } else if (request.getParameter("_finish") != null) {
            // User is finished, make reservation
            validator.validate(reservation, result);
            if (!result.hasErrors()) {
                reservationService.makePeriodic(reservation);
                status.setComplete();
                return "redirect:reservationSuccess";
            } else {
            // Errors
                return (String) pageForms.get(currentPage);
            }

        } else {
            // User clicked Next or Previous(_target)
            // Extract target page
            int targetPage = WebUtils.getTargetPage(request, "_target", currentPage);
            // If targetPage is lesser than current page, user clicked 'Previous'
            if (targetPage < currentPage) {
                return (String) pageForms.get(targetPage);
            }
            // User clicked 'Next', return target page
            switch (currentPage) {
                case 0:
                    validator.validateCourt(reservation, result);
                    break;
                case 1:
                    validator.validateTime(reservation, result);
                    break;
                case 2:
                    validator.validatePlayer(reservation, result);
                    break;
            }
            if (!result.hasErrors()) {
            // No errors, return target page
                return (String) pageForms.get(targetPage);
            } else {
            // Errors, return current page
                return (String) pageForms.get(currentPage);
            }
        }
    }


    @ModelAttribute("periods")
    public Map<Integer, String> periods() {
        Map<Integer, String> periods = new HashMap<Integer, String>();
        periods.put(1, "Daily");
        periods.put(7, "Weekly");
        return periods;
    }
}
