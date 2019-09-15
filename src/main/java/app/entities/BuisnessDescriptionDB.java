package app.entities;

import app.models.BuisnessDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

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
    @Column(length = 2048)
    private String descriptionText;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "information_id", referencedColumnName = "id")
    private BuisnessInformationDB buisnessInformation;

    @OneToMany(mappedBy = "buisnessDescriptionDB", cascade = CascadeType.ALL)
    private Set<PaymentDB> paymentDB;

    public BuisnessDescriptionDB(BuisnessDescription bd) {
        name = bd.getName();
        category = bd.getCategory();
        iconURL = bd.getIconURL();
        descriptionText = bd.getDescriptionText();

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
