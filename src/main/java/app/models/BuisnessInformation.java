package app.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name="description")
@Builder
@Data
public class BuisnessInformation {
    @Id
    @GeneratedValue
    private long id;
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
}
