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

        restTemplate.delete(fooResourceUrl);

        Graphic graphic = Graphic.builder()
                .x(new ArrayList<>(Arrays.asList(200d, 300d, 450d, 700d, 750d, 650d, 600d, 650d)))
                .y(new ArrayList<>(Arrays.asList(0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d)))
                .build();


        BuisnessDescription bd = BuisnessDescription.builder()
                .name("KhanAcademy")
                .category("education")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/khan.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);

        bd = BuisnessDescription.builder()
                .name("edX")
                .category("education")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/edx.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);

        bd = BuisnessDescription.builder()
                .name("intel")
                .category("IT")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/intel.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);

        bd = BuisnessDescription.builder()
                .name("Microsoft")
                .category("IT")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/microsoft.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
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

        bd = BuisnessDescription.builder()
                .name("Инфомаксимум")
                .category("IT")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/l_5d5fdaf260459.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);

        bd = BuisnessDescription.builder()
                .name("3Dexter")
                .category("education")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/3DexterLogo.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);

        bd = BuisnessDescription.builder()
                .name("Opensignal")
                .category("IT")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/opensignal.png")
                .profit(graphic)
                .revenue(graphic)
                .debts(graphic)
                .assets(graphic)
                .capital(graphic)
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);


//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    public static <T> ArrayList<T> toArrayList(List<T> list) {
        return new ArrayList<>(list);
    }
}
