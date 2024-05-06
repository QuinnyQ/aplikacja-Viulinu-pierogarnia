package com.pierogarnia.viulinu;

import com.pierogarnia.viulinu.model.Item;
import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.order.OrderItem;
import com.pierogarnia.viulinu.model.user.Person;
import com.pierogarnia.viulinu.repository.ItemRepository;
import com.pierogarnia.viulinu.repository.PersonRepository;
import com.pierogarnia.viulinu.repository.order.OrderItemRepository;
import com.pierogarnia.viulinu.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    public String dateStr = "2022-02-16T10:22:15";

    // Convert String to LocalDateTime using Parse() method
    LocalDateTime localDateTime = LocalDateTime.parse(dateStr);

    private final ItemRepository itemRepository;
    private final PersonRepository personRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    @Autowired
    public DbInit(ItemRepository itemRepository, PersonRepository personRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.itemRepository = itemRepository;
        this.personRepository = personRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("Verde Mate Green Terere 0,5kg", new BigDecimal("25.46"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Terere-0-5kg-4024_2.png",
                        "Verde Mate Green Terere to yerba pochodząca z Brazylii. Susz nie pochodzi z regularnej plantacji, lecz dorasta w najprawdziwszym tropikalnym lesie pod okiem ekspertów z kameralnego przedsiębiorstwa w stanie Parana.",
                        "Grubo cięte, świeże listki yerba mate, jagody goi, trawa cytrynowa, kostka ananasa, skórka pomarańczy, liść mięty, Naturalny wegański aromat.",
                        "Mocno roślinny i pobudzający napar pozbawiony dymnych aromatów. Wyczuwalne zróżnicowane akcenty owocowe idealnie komponujące się z całością i orzeźwiają.",
                        "ZIELONA YERBA MATE"),
                new Item("Soul Mate Organica Energia 0,5kg (organiczna)", new BigDecimal("34.20"),
                        "https://www.matemundo.pl/zul_pm_Soul-Mate-Organica-Energia-0-5kg-organiczna-7550_5.png",
                        "Soul Mate Orgánica Energia to połączenie najwyższej jakości brazylijskiej yerba mate z organicznej plantacji z guaraną i trawą cytrynową, które poskutkowało uzyskaniem mocno pobudzającej i przepysznej mieszanki!",
                        "94,7% yerba mate, trawa cytrynowa, guarana, naturalny olejek.",
                        "Delikatnie roślinna, bezdymna yerba mate bez nadmiernej nuty goryczy dopełnione orzeźwiającym dodatkiem guarany i kwaskowatą trawą cytrynową. Na plus zasługuje również wysoka wydajność suszu.",
                        "ORGANICZNA YERBA MATE"),
                new Item("Verde Mate Green La Potente 0,5kg", new BigDecimal("21.50"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-La-Potente-0-5kg-4561_4.png",
                        "Verde Mate La Potente to yerba pochodząca z Brazylii. Wyrafinowana kompozycja yerba mate zawiera jarzębinę, korę catuaby i muira puama, lapacho oraz liście ginkgo biloba. Połączenie tego typu zaskoczy Cię wytrawnym smkiem i aromatem.",
                        "Yerba mate, jarzębina, kora katuavy, kora muira puama, lapacho, liści ginkgo biloba, naturalny, wegański aromat.",
                        "Mocno roślinny i pobudzający napar pozbawiony dymnych aromatów. Słodkawe nuty typowe dla zielonego, praktycznie wolnego od wędzenie suszu w połączeniu z afrodyzjakami tworzą wysmakowaną mieszankę yerba mate.",
                        "ZIELONA YERBA MATE"),
                new Item("Verde Mate Green Winter Edition 0,5kg", new BigDecimal("28.41"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Winter-Edition-0-5kg-8224_4.png",
                        "Verde Mate Winter Edition to limitowana wariacja smakowa popularnej brazylijskiej yerba mate znanej z łagodnego aromatu i dużej zawartości kofeiny. Każda paczka zawiera świeży susz yerba mate wraz z dodatkami.",
                        "Ostrokrzew paragwajski, jabłko, cynamon, naturalne aromaty.",
                        "Delikatny smak zielonej yerba mate w połączeniu z naturalnymi dodatkami o wspaniałym, eterycznym aromacie. Doskonale rozgrzewa, polecana przede wszystkim w formie ciepłego naparu.",
                        "ZIELONA YERBA MATE"),
                new Item("Soul Mate Cannabis 0,5kg (organiczna)", new BigDecimal("31.34"),
                        "https://www.matemundo.pl/zul_pm_Soul-Mate-Organica-Cannabis-0-5kg-organiczna-8629_5.png",
                        "Soul Mate Orgánica to marka wywodząca się z Brazylii, która oferuje wysokiej jakości yerby opatrzone certyfikatem organiczności. Dużą zaletą produktów są dobrze dobrane naturalne składniki.",
                        "89,7 % yerba mate, trawa cytrynowa, mięta, 1% mąka konopna, guayusa, olejki naturalne, składniki pochodzenia organicznego.",
                        "Lekko owocowy i łagodny aromat otulony przyjemnym i naturalnym smakiem. Produkt o niecodziennej kompozycji polecany jest wszystkim, którzy szukają naturalnego pobudzenia i ekologicznych składników.",
                        "ORGANICZNA YERBA MATE"),
                new Item("Soul Mate Organica Frosty Season 0,5kg (organiczna)", new BigDecimal("34.29"),
                        "https://www.matemundo.pl/zul_pm_Soul-Mate-Organica-Frosty-Season-0-5kg-organiczna-8103_5.png",
                        "Brazylijska marka znana z produkcji organicznych yerba mate zaskoczyła nas limitowaną wariacją smakową przygotowaną specjalnie z myślą o sezonie jesienno-zimowym!",
                        "Ekologiczna yerba mate, ekologiczna ilex guayusa, ekologiczna trawa cytrynowa, ekologiczny cynamon, naturalny olejek pomarańczowy, naturalny olejek goździkowy.",
                        "Głęboki aromat goździków i cynamonu przypominający nieco grzane wino w zgrabnym połączeniu z delikatną w smaku, a jednocześnie doskonale pobudzającą yerba mate i ilex guayusa.",
                        "ORGANICZNA YERBA MATE"),
                new Item("Verde Mate Green Summertime 0,5kg", new BigDecimal("25.47"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Summertime-0-5kg-8767_5.png",
                        "Verde Mate Green Summertime to limitowana wariacja smakowa słynnej brazylijskiej marki ze stanu Parana. Będzie dostępna wyłącznie latem, dlatego nie warto zwlekać z zakupem!",
                        "91% yerba mate, trawa cytrynowa, skórka pomarańczy, mięta, płatki nagietka, naturalny olejek mandarynkowy, naturalne aromaty",
                        "Orzeźwiający miks yerba mate, mięty i smaku cytrusów. Doskonała w formie lodowatego tereré na ochłodę!",
                        "ZIELONA YERBA MATE"),
                new Item("Verde Mate Green Mas IQ 0,5kg", new BigDecimal("25.47"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Mas-IQ-0-5kg-4240_3.png",
                        "Pobudzenie, wspaniały smak i aromat. Verde Mate Más IQ jest kompozycją perfekcyjną w każdym calu. Nic innego nie działa tak jak ona! Poza zieloną brazylijską mate z dzikiej leśnej uprawy zawiera wyciąg z gingko biloba i żeń-szeń.",
                        "Grubo cięte zielone listki yerba mate praktycznie bez patyczków i pyłu, guarana, ananas, skórka pomarańczy, żeń-szeń, ginkgo biloba, płatki bławatka, naturalne aromaty mango i pomarańczy.",
                        "Dzięki dodanej do całości skórce pomarańczy aromat jest świeży i głęboki. Składniki o korzennych charakterze w połączeniu z owocami okazały się tworzyć bardzo zgrany i udany tandem.",
                        "ZIELONA YERBA MATE"),
                new Item("Verde Mate Green Frutos Tropicales 0,5kg", new BigDecimal("21.54"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Frutos-Tropicales-0-5kg-4225_3.png",
                        "Verde Mate Green Frutos Tropicales to yerba pochodząca z Brazylii. Wyrafinowana kompozycja naturalnie owocowych smaków. Połączenie skórki z pomarańczy i wiórkami kokosowymi sprawią, że na nowo odkryjesz yerba mate.",
                        "Grubo cięte, świeże listki yerba mate, jagody goji, ananas kostka, skórka z pomarańczy, pomelo kostka, chipsy kokosowe, naturalne aromaty.",
                        "Mocno roślinny i pobudzający napar pozbawiony dymnych aromatów. Soczyste nuty typowe dla mocno zielonego, praktycznie wolnego od wędzenia suszu. Owocowe dodatki nadają całości nieco słodkawego, orzeźwiającego charakteru.",
                        "ZIELONA YERBA MATE"),
                new Item("Verde Mate Green Limon (cytrynowa) 0,5kg", new BigDecimal("25.46"),
                        "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Limon-cytrynowa-0-5kg-4008_4.jpg ",
                        "Verde Mate Limón to yerba pochodząca z dzikiej leśnej uprawy zlokalizowanej w brazylijskiej dżungli. To wyrafinowana kompozycja naturalnie cytrusowych smaków. Połączenie trawy cytrynowej ze skórką cytryny zaskoczą Cię wytrawnym orzeźwieniem.",
                        "Grubo cięte, świeże listki yerba mate, skórka z cytryny, trawa cytrynowa, naturalny, wegański aromat.",
                        "Mocno roślinny i pobudzający napar pozbawiony dymnych aromatów. Słodkawe nuty typowe dla mocno zielonego, praktycznie wolnego od wędzenie suszu. Świeży owocowy posmak cytrusów znakomicie dopełniający charakter yerba mate.",
                        "ZIELONA YERBA MATE"),
                new Item("Verde Mate Green Passionate Fruits 0,5 kg", new BigDecimal("25.47"), "https://www.matemundo.pl/zul_pm_Verde-Mate-Green-Passionate-Fruits-0-5-kg-9864_2.png",
                        "Verde Mate Green Passionate Fruits to niezwykle bogata fuzja smaków, której nie będziesz w stanie się oprzeć! Kuszące połączenie różnorodnych owoców: kandyzowanej papai, czarnej porzeczki, jagód goji i marakui.",
                        "88,6 % yerba mate, 3 % kandyzowana papaja, 3 % czarna porzeczka, 1 % marakuja, jagody goji, płatki bławatka, hibiskus, naturalny aromat papai, naturalny olejek limonkowy.",
                        "Smak i aromat kuszą już od pierwszego łyku i powąchania. Spróbuj i sam się przekonaj!",
                        "ZIELONA YERBA MATE"),
                new Item("Soul Mate Organica Menta Limon 0,5kg (organiczna)", new BigDecimal("29.39"),
                        "https://www.matemundo.pl/zul_pm_Soul-Mate-Organica-Menta-Limon-0-5kg-organiczna-7547_4.png",
                        "Soul Mate Orgánica Menta Limon to połączenie najwyższej jakości brazylijskiej yerba mate z organicznej plantacji z trawą cytrynową, miętą i skórką cytryny.",
                        "85% yerba mate, trawa cytrynowa, mięta, skórka cytryny, naturalny olejek.",
                        "Delikatnie roślinna, bezdymna yerba mate bez nadmiernej nuty goryczy dopełnione orzeźwiającym dodatkiem trawy cytrynowej, mięty i skórki cytryny.",
                        "ORGANICZNA YERBA MATE"),


                new Item("Szydełkowy sweterek Arabela na tykwie", new BigDecimal("79.90"),
                        "https://www.matemundo.pl/zul_pm_Szydelkowy-sweterek-Arabela-na-tykwie-9640_1.png",
                        "Przedstawiamy wam szydełkowy, ręcznie wykonany sweterek na tykwę! Dziergany z najwyższą dbałością o szczegóły, przez lokalną artystkę z podlubelskiej miejscowości, dla której ręczne robótki są pasją. Każdy egzemplarz jest jedyny w swoim rodzaju.",
                        "",
                        "",
                        "TYKWY W SWETERKU"),
                new Item("Szydełkowy sweterek Olimpia na tykwie", new BigDecimal("89.90"),
                        "https://www.matemundo.pl/zul_pm_Szydelkowy-sweterek-Olimpia-na-tykwie-9584_4.png",
                        "Dzięki szydełkowemu ubranku twoje ulubione matero nabierze oryginalnego charakteru. To świetna propozycja na chłodne jesienno-zimowe wieczory - ale nie tylko! Ogrzewacz sprawi, że yerba mate dłużej zachowa swoją temperaturę.",
                        "",
                        "",
                        "TYKWY W SWETERKU"),
                new Item("Tykwa Ceramiczna z logo Verde Mate - 350 ml", new BigDecimal("29.39"),
                        "https://www.matemundo.pl/zul_pm_Tykwa-Ceramiczna-z-logo-Verde-Mate-Winter-Time-350-ml-9734_2.png",
                        "Tykwa Verde Mate Winter Time - praktyczne naczynko do yerba mate, z wysokiej jakości ceramiki, w specjalnej, limitowanej edycji, przygotowanej na sezon zimowy. Matero przyozdobione jest logo marki Verde Mate, w świątecznym wydaniu.",
                        "",
                        "",
                        "KOLOROWE NACZYNKA"),
                new Item("Tykwa Ceramiczna - Snowman 350 ml", new BigDecimal("14.30"),
                        "https://www.matemundo.pl/zul_pm_Tykwa-Ceramiczna-Snowman-350-ml-9733_1.png",
                        "Tykwa Snowman - praktyczne naczynko do yerba mate, z wysokiej jakości ceramiki, w specjalnej, limitowanej edycji, przygotowanej na sezon zimowy. Matero przyozdobione jest świątecznym motywem.",
                        "",
                        "",
                        "KOLOROWE NACZYNKA"),
                new Item("Tykwa Ceramiczna z logo El Fuego (czerwona) 300 ml", new BigDecimal("23.51"),
                        "https://www.matemundo.pl/zul_pm_Tykwa-Ceramiczna-z-logo-El-Fuego-czerwona-300-ml-9732_1.png",
                        "Tykwa ceramiczna z logo El Fuego w czerwonym kolorze - stylowe, praktyczne naczynko do picia yerba mate. Szkliwiona wewnątrz oraz na zewnątrz. Estetyczna, solidnie wykonana i łatwa w konserwacji oraz użytkowaniu.",
                        "",
                        "",
                        "KOLOROWE NACZYNKA"),
                new Item("Szydełkowy sweterek Valeria na tykwie", new BigDecimal("89.90"),
                        "https://www.matemundo.pl/zul_pm_Szydelkowy-sweterek-Valeria-na-tykwie-10280_1.png",
                        "Sweterek wykonany jest z wysokiej jakości włóczki, w kolorach błękitu. Na sweterku umieszczone jest logo producenta wykonane z jasnobrązowej ekoskóry. Do sweterka dołączone jest białe ceramiczne matero z logo Guarani.",
                        "",
                        "",
                        "TYKWY W SWETERKU"),
                new Item("Tykwa ceramiczna - Yaguar Gatito 300 ml", new BigDecimal("29.39"),
                        "https://www.matemundo.pl/zul_pm_Tykwa-ceramiczna-Yaguar-Gatito-300-ml-9374_1.png",
                        "Yaguar Gatito to ceramiczna tykwa do yerba mate o oryginalnym designie - kształtem przypomina głowę jaguara, majestatycznego króla amazońskiej dżungli. Picie yerby w takim naczynku jest jeszcze smaczniejsze!",
                        "",
                        "",
                        "KOLOROWE NACZYNKA"),
                new Item("Szydełkowy sweterek Nieve na tykwie", new BigDecimal("89.90"),
                        "https://www.matemundo.pl/zul_pm_Szydelkowy-sweterek-Nieve-na-tykwie-10338_2.png",
                        "Sweterek wykonany jest z wysokiej jakości włóczki. Na sweterku umieszczone jest logo producenta wykonane z jasnobrązowej ekoskóry. Do sweterka dołączone jest ceramiczne matero.",
                        "",
                        "",
                        "TYKWY W SWETERKU")

        ));
        personRepository.saveAll(List.of(
                new Person("admin@admin", new BCryptPasswordEncoder().encode("admin"), "admin","ROLE_ADMIN"),
                new Person("anna@wp.pl",  new BCryptPasswordEncoder().encode("anna"), "anna123","ROLE_USER"),
                new Person("ala@wp.pl",  new BCryptPasswordEncoder().encode("ala"), "alamakota","ROLE_USER"),
                new Person("pola@wp.pl",  new BCryptPasswordEncoder().encode("pola"), "pola123","ROLE_USER")


        ));
        orderRepository.saveAll(List.of(
                new Order("Anna","Nowak",localDateTime,"Polna 11","01-100","Warszawa","158.36","anna123"),
                new Order("Ala","Makota",localDateTime,"Ogrodowa 12","60-600","Poznań","68.40","alamakota")
        ));
        orderItemRepository.saveAll(List.of(
            new OrderItem(1L, 1L,1),
            new OrderItem(1L, 2L,2),
            new OrderItem(1L, 3L,3),
            new OrderItem(2L, 2L,2)
        ));
    }
}
