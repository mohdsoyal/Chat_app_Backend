package chat_app.com.Payload;

import java.time.LocalDateTime;



public class MessageRequest {
	

	    private String sender;
	    private String content;
	    private LocalDateTime timeStamp;

	    public MessageRequest(String sender, String content, LocalDateTime timeStamp) {
	        this.sender = sender;
	        this.content = content;
	        this.timeStamp = timeStamp;
	    }

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
	    
	    
	    
	}

	

	


