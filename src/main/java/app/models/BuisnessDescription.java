package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="description")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuisnessDescription {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String category;
    private String iconURL;
}
