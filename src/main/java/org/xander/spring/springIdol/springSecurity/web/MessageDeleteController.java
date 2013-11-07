package org.xander.spring.springIdol.springSecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xander.spring.springIdol.springSecurity.domain.Message;
import org.xander.spring.springIdol.springSecurity.service.MessageBoardService;

@Controller
@RequestMapping("/messageDelete*")
public class MessageDeleteController {
    private MessageBoardService messageBoardService;

    @Autowired
    public void MessageDeleteController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String messageDelete(@RequestParam(required = true, value = "messageId") Long messageId,
                               Model model) {
        Message message = messageBoardService.findMessageById(messageId);
        messageBoardService.deleteMessage(message);
        model.addAttribute("messages", messageBoardService.listMessages());
        return "redirect:messageList";
    }
}
