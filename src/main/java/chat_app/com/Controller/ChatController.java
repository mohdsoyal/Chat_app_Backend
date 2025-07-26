package chat_app.com.Controller;

import chat_app.com.Entity.Message;
import chat_app.com.Payload.MessageRequest;
import chat_app.com.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public MessageRequest sendMessage(@DestinationVariable String roomId, MessageRequest request) {
        Message message = chatService.sendMessage(roomId, request);
        return new MessageRequest(message.getSender(), message.getContent(), message.getTimeStamp());
    }


}
