package org.xander.spring.springIdol.springSecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xander.spring.springIdol.springSecurity.domain.Message;
import org.xander.spring.springIdol.springSecurity.service.MessageBoardService;

import java.util.List;

@Controller
@RequestMapping("/messageList*")
public class MessageListController {
    private MessageBoardService messageBoardService;

    @Autowired
    public MessageListController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String generateList(Model model) {
        List<Message> messages = java.util.Collections.emptyList();
        messages = messageBoardService.listMessages();
        model.addAttribute("messages",messages);
        return "messageList";
    }


}
