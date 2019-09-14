package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="description")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuisnessDescriptionDB {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String category;
    private String iconURL;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private BuisnessInformationDB buisnessInformation;
}
