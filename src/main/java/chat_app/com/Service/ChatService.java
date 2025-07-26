package chat_app.com.Service;

import chat_app.com.Entity.Message;
import chat_app.com.Payload.MessageRequest;

public interface ChatService {
	
	 Message sendMessage(String roomId, MessageRequest request);

}
