package chat_app.com.Service;

import java.util.List;

import chat_app.com.Entity.Message;
import chat_app.com.Entity.Room;

public interface RoomService {
	
	 
	    
	    Room createRoom(String roomId);
	    Room getRoom(String roomId);
	    List<Message> getMessages(String roomId, int page, int size);
	
	

}
