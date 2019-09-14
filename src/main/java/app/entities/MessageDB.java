package app.entities;

import app.models.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="messages")
@NoArgsConstructor
public class MessageDB {
    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private LocalDateTime date;
    private boolean isBot;

    public MessageDB(Message message) {
        this.id = message.getId();
        this.body = message.getBody();
        this.date = message.getDate();
        this.isBot = message.isBot();
    }
}
