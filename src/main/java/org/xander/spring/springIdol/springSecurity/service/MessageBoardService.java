package org.xander.spring.springIdol.springSecurity.service;

import org.xander.spring.springIdol.springSecurity.domain.Message;

import java.util.List;

public interface MessageBoardService {
    List<Message> listMessages();
    void postMessage(Message message);
    void deleteMessage(Message message);
    Message findMessageById(Long messageId);
}
