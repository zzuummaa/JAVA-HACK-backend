package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="information")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuisnessInformationDB {
    @Id
    @GeneratedValue
    private Long id;
    ArrayList<Double> profitX;
    ArrayList<Double> profitY;
    ArrayList<Double> revenueX; //выручка
    ArrayList<Double> revenueY;
    ArrayList<Double> debtsX;
    ArrayList<Double> debtsY; //долги
    ArrayList<Double> assetsX; //активы
    ArrayList<Double> assetsY;
    ArrayList<Double> capitalX; //активы
    ArrayList<Double> capitalY;

    @OneToOne(mappedBy = "buisnessInformation")
    private BuisnessDescriptionDB buisnessDescription;
}