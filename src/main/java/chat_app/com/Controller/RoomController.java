package chat_app.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import chat_app.com.Entity.Message;
import chat_app.com.Entity.Room;
import chat_app.com.Service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin("https://chat-app-ui-fawn.vercel.app")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody Room request) {
        Room room = roomService.createRoom(request.getRoomId());
        return ResponseEntity.ok(room);
    }


    @GetMapping("/{roomId}")
    public ResponseEntity<?> getRoom(@PathVariable String roomId) {
       
            Room room = roomService.getRoom(roomId);
            return ResponseEntity.ok(room);
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        List<Message> messages = roomService.getMessages(roomId, page, size);
        return ResponseEntity.ok(messages);
    }
}
