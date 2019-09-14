package app.entities;

import app.models.BuisnessDescription;
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
    private Long id;
    private String name;
    private String category;
    private String iconURL;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private BuisnessInformationDB buisnessInformation;

    public BuisnessDescriptionDB(BuisnessDescription bd) {
        name = bd.getName();
        category = bd.getCategory();
        iconURL = bd.getIconURL();
        description = bd.getDescription();

        if (bd.getProfit() == null ||
            bd.getRevenue() == null ||
            bd.getDebts() == null ||
            bd.getAssets() == null ||
            bd.getCapital() == null) {
            return;
        }

        buisnessInformation = new BuisnessInformationDB(
        null,
            bd.getProfit().getX(),
            bd.getProfit().getY(),
            bd.getRevenue().getX(),
            bd.getRevenue().getY(),
            bd.getDebts().getX(),
            bd.getDebts().getY(),
            bd.getAssets().getX(),
            bd.getAssets().getY(),
            bd.getCapital().getX(),
            bd.getCapital().getY(),
            this
        );
    }
}
