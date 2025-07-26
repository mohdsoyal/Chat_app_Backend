package chat_app.com.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import chat_app.com.Entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long>{

}
