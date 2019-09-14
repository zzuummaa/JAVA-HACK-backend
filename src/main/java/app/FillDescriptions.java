package app;

import app.models.BuisnessDescription;
import app.models.Graphic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillDescriptions {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://zzuummaa.sytes.net:8070/investments/businesses";

        Graphic graphic = Graphic.builder()
            .x(new ArrayList<>(Arrays.asList(200d, 300d, 450d, 700d, 750d, 650d, 600d, 650d)))
            .y(new ArrayList<>(Arrays.asList(0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d)))
            .build();

        for (int i = 0; i < 10; i++) {
            BuisnessDescription bd = BuisnessDescription.builder()
                    .name("Microsoft")
                    .category("IT")
                    .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/microsoft.png")
                    .profit(graphic)
                    .revenue(graphic)
                    .debts(graphic)
                    .assets(graphic)
                    .capital(graphic)
                    .build();
            ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
            System.out.println(response);

            bd = BuisnessDescription.builder()
                    .name("Disney")
                    .category("entertainment")
                    .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/disney.png")
                    .profit(graphic)
                    .revenue(graphic)
                    .debts(graphic)
                    .assets(graphic)
                    .capital(graphic)
                    .build();
            response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
            System.out.println(response);

            bd = BuisnessDescription.builder()
                    .name("BMSTU")
                    .category("education")
                    .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/bauman.png")
                    .profit(graphic)
                    .revenue(graphic)
                    .debts(graphic)
                    .assets(graphic)
                    .capital(graphic)
                    .build();
            response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
            System.out.println(response);
        }

//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    public static <T> ArrayList<T> toArrayList(List<T> list) {
        return new ArrayList<>(list);
    }
}
