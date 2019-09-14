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
                .descriptionText("The Khan Academy is a non-profit educational organization that provides free video tutorials and interactive exercises. The Academy's declared mission is “changing education for the better by providing a free world-class education to anyone anywhere")
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
                .descriptionText("edX is a massive open online course (MOOC) provider. It hosts online university-level courses in a wide range of disciplines to a worldwide student body, including some courses at no charge. It also conducts research into learning based on how people use its platform")
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
                .descriptionText("Intel Corp. engages in the design, manufacture, and sale of computer products and technologies. It delivers computer, networking, data storage and communications platforms.")
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
                .descriptionText("Microsoft is a leading global vendor of computer software; hardware for computer, mobile and gaming systems; and cloud services. Microsoft's corporate headquarters is located in Redmond, Wash., and it has offices in more than 60 countries.")
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
                .descriptionText("The Walt Disney Co. is a diversified international family entertainment and media enterprise. It operates through the following segments: Media Networks, Parks & Resorts, Studio Entertainment and Consumer Products & Interactive Media.")
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
                .descriptionText("Bauman Moscow State Technical University (BMSTU) is the leading Russian university, that has throughout more than 175 years of its history brought to life outstanding scientists and researchers, who were pioneers in World rocketry, aviation and heavy industry. BMSTU is featured in a number of QS rankings.")
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
                .descriptionText("Infomax Solutions is an IT solution and service provider for small businesses in San Diego area. We manage your IT so that you can focus on your core business.")
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
                .descriptionText("3Dexter is an Education company bringing Experiential " +
                        "Learning- in schools and colleges using 3D Printing- and other futuristic" +
                        " technologies- . We envision 3D Technology to be at the core of innovation." +
                        " The motive is to enable the students to imagine, dream and turn them into" +
                        " reality")
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
                .descriptionText("Opensignal is an independent mobile analytics company specialising in quantifying " +
                        "mobile network experience. The company uses real-world mobile network data of users across" +
                        " the world to power its mobile analytics product suite as well as to produce mobile network" +
                        " analyses on over 88 countries across the world.")
                .build();
        response = restTemplate.postForEntity(fooResourceUrl, bd, String.class);
        System.out.println(response);


//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    public static <T> ArrayList<T> toArrayList(List<T> list) {
        return new ArrayList<>(list);
    }
}
