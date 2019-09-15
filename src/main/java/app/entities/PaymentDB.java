package app.entities;

import app.models.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="payments")
@NoArgsConstructor
public class PaymentDB {
    @Id
    @GeneratedValue
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private BuisnessDescriptionDB buisnessDescriptionDB;

    public PaymentDB(Payment payment) {
        id = payment.getId();
        amount = payment.getAmount();
        buisnessDescriptionDB = BuisnessDescriptionDB.builder()
                .id(payment.getBusiness_id())
                .build();
    }
}
