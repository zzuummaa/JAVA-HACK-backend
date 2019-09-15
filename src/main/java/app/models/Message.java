package app.models;

import app.entities.MessageDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private LocalDateTime date;
    private boolean isBot;
    public Message(MessageDB messageDB) {
        id = messageDB.getId();
        body = messageDB.getBody();
        date = messageDB.getDate();
        isBot = messageDB.isBot();
    }
}
