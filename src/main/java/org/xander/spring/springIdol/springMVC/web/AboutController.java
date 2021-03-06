package org.xander.spring.springIdol.springMVC.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
        @Value("#{ messageSource.getMessage('admin.email',null,'en')}")
        private String email;

        @RequestMapping("/about")
        public String courtReservation(Model model) {
            model.addAttribute("email", email);
            return "about";
        }
}
