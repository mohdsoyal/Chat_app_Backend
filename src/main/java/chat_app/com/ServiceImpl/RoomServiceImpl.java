package chat_app.com.ServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chat_app.com.Entity.Message;
import chat_app.com.Entity.Room;
import chat_app.com.Repositry.RoomRepo;
import chat_app.com.Service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public Room createRoom(String roomId) {
        if (roomRepo.findByRoomId(roomId).isPresent()) {
            throw new RuntimeException("Room already exists");
        }

        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepo.save(room);
    }

    
    @Override
    public Room getRoom(String roomId) {
        return roomRepo.findByRoomId(roomId)
                       .orElseThrow(() -> new RuntimeException("Room not found"));
    }


    @Override
    public List<Message> getMessages(String roomId, int page, int size) {
        Room room = roomRepo.findByRoomId(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        List<Message> messages = room.getMessages();
        Collections.reverse(messages);

        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        return messages.subList(start, end);
    }
}
