package chat_app.com.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore 
    private Room room;
}
