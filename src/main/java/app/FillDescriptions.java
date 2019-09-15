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
                .descriptionText("Khan Academy, она же Академия Хана, названа по имени своего основателя — Салмана Хана. В 2006 году он создал этот ресурс в качестве хобби: рисовал формулы, решал примеры и записывал процесс на видео, сопровождая достаточно неформальными комментариями свои действия. Первоначально сайт был рассчитан только на учеников с минимальными знаниями по техническим предметам, но сейчас там есть и более сложные лекции. Эта платформа идеально подойдет тем, кто привык двигаться в своем темпе и только начинает свой путь в мире онлайн-образования. Все уроки на сайте, конечно, бесплатны.")
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
                .descriptionText("Целью проекта EDX является создание для дистанционного образования открытой и свободной платформы для бесплатного обучения всех желающих. Данный проект содержит онлайн курсы, содержание которых соответствует самому высокому университетскому уровню и рассчитан на международную аудиторию.")
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
                .descriptionText("Компания Intel является сегодня крупнейшим производителем полупроводников в мире. Она изменила наш мир не меньше, чем это сделали Apple и Microsoft в свое время (а если говорить точнее, то они ничего бы не сделали без Intel). Ведь Intel изобрела микропроцессор – сердце современных компьютеров. В начале XXI века процессоры Intel были установлены более чем на 80% компьютеров по всему миру. Сегодня Intel выпускает достаточно широкий спектр продукции, который не заканчивается на одних лишь процессорах. Так, компания производит материнские платы, флэш память, концентраторы и маршрутизаторы, концептуальные ноутбуки и многое другое.")
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
                .descriptionText("Microsoft (Nasdaq “MSFT” @microsoft) обеспечивает условия для цифровой трансформации в эпоху «интеллектуального облака» и «интеллектуальных технологий». Миссия компании – дать возможность каждому человеку и организации на планете достичь большего.")
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
                .descriptionText("Сегодня Walt Disney Company – это компания-конгломерат, которая занимается не только съемкой и продюссированием мультфильмов и семейных кинофильмов. В активе Уолт Диснея находится большой список сфер из индустрии развлечений")
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
                .descriptionText("Ведущий технический вуз России, которому удается оказываться в первой пятерке, как специализированных, так и общих рейтингов университетов. В «Бауманку» проще поступить, чем ее закончить. Неофициальная статистика свидетельствует, что доучиться до победного конца не удается более четверти студентов - требования к качеству знаний в вузе крайне высоки. Студенты университета привлекаются к реальной исследовательской работе, многие из них выбирают «научно-исследовательское будущее» и продолжают обучение в аспирантуре. Пограммисты из Бауманки известны во всем мире и востребованы не только в России, но и за рубежом.")
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
                .descriptionText("ООО «Инфомаксимум» образована в 2008 году. Основная деятельность — разработка высокопроизводительных сетевых систем. На данный момент выиграно более 11 федеральных и региональных научных грантов. Сотрудники компании не раз становились призерами всероссийских математических олимпиад. ООО «Инфомаксимум» является разработчиком и владельцем системы учета рабочего времени CrocoTime.")
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
