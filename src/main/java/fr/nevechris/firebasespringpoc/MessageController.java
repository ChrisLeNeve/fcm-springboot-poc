package fr.nevechris.firebasespringpoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping("/send-message")
    public void sendSampleMessage() {
        service.sendFirebaseMessage();
    }
}
