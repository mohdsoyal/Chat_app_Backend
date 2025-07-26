package chat_app.com.Repositry;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import chat_app.com.Entity.Room;

public interface RoomRepo extends JpaRepository<Room, Long>{
	
	// get room using room id;
	
	Optional<Room> findByRoomId(String roomId);

}
