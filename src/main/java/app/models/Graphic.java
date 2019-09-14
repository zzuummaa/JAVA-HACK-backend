package app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graphic {
    private ArrayList<Double> x;
    private ArrayList<Double> y;
}
