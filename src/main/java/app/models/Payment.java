package app.models;

import app.entities.PaymentDB;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private double amount;
    private Long business_id;

    public Payment(PaymentDB paymentDB) {
        id = paymentDB.getId();
        amount = paymentDB.getAmount();
        business_id = paymentDB.getBuisnessDescriptionDB().getId();
    }
}
