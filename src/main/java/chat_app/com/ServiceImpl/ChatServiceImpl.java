package chat_app.com.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chat_app.com.Entity.Message;
import chat_app.com.Entity.Room;
import chat_app.com.Payload.MessageRequest;
import chat_app.com.Repositry.MessageRepo;
import chat_app.com.Repositry.RoomRepo;
import chat_app.com.Service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public Message sendMessage(String roomId, MessageRequest request) {
        // Fetch the room by roomId
        Room room = roomRepo.findByRoomId(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Create and populate the message
        Message message = new Message();
        message.setSender(request.getSender());
        message.setContent(request.getContent());
        message.setTimeStamp(LocalDateTime.now());
        message.setRoom(room); // Link to the room

        // Save message directly without touching room.getMessages()
        return messageRepo.save(message);
    }
}
