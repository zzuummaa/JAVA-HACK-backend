package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuisnessDescription {
    private long id;
    private String name;
    private String category;
    private String iconURL;

    private Graphic profit;
    private Graphic revenue;
    private Graphic debts;
    private Graphic assets;
    private Graphic capital;

    public BuisnessDescription(BuisnessDescriptionDB bd) {
        id = bd.getId();
        name = bd.getName();
        category = bd.getCategory();
        iconURL = bd.getIconURL();

        BuisnessInformationDB bi = bd.getBuisnessInformation();
        if (bi == null) return;

        profit = new Graphic(
                bi.getProfitX(),
                bi.getProfitY()
        );

        revenue = new Graphic(
                bi.getRevenueX(),
                bi.getRevenueY()
        );
        debts = new Graphic(
                bi.getDebtsX(),
                bi.getDebtsY()
        );
        assets = new Graphic(
                bi.getAssetsX(),
                bi.getAssetsY()
        );
        capital = new Graphic(
                bi.getCapitalX(),
                bi.getCapitalY()
        );
    }
}
