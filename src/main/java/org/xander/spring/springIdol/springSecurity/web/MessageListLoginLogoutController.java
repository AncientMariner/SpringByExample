package org.xander.spring.springIdol.springSecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xander.spring.springIdol.springSecurity.service.MessageBoardService;

@Controller
public class MessageListLoginLogoutController {
    private MessageBoardService messageBoardService;

    @Autowired
    public MessageListLoginLogoutController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login";
    }
}
