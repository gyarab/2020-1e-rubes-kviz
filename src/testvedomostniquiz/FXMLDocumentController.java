/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvedomostniquiz;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Adam
 */
public class FXMLDocumentController implements Initializable {

    public static int test = 1;

    Integer[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    String[] poleOtazekTechnika = new String[]{
        "Kdo vynalezl žárovku?", //[0]
        "Kdo sestrojil první galvanycký článek?",//[1]
        "Jaká společnost vlastní Javu?",//[2]
        "Co znamená prefix WWW?",//[3]
        "Jaký operační systém vyvýjí Google?",//[4]
        "Kdo je zakladatelem Facebooku?",//[5]
        "Co znamená FTP?",//[6]
        "Jaká zkratka se používá pro procesor?",//[7]
        "Jak se jmenoval první superpočítač?",//[8]
        "Kdy byl založen google?",//[9]
        "Kdo vynalezl kontaktní čočky?",//[10]
        "Jak se jmenoval počítač který porazil Kasparova",//[11]
        "Po kom je pojmenovaná značka mercedes?",//[12]
        "Kdy bylo vynalezeno kolo?",//[13]
        "Kdy byl vynalezen mobilní telefon?",//[14]
        "Kdo vynalezl kaplanovu turbínu?",//[15]
        "Z jakého materiálu jsou gramofonové desky?",//[16]
    };

    String[][] poleOdpovediTechnika = new String[][]{
        {"Thomas A. Edison", "Jaroslav Heyrovský", "Nikola Tesla", "Robert Oppenheimer"},//Berlin je spravne [0]
        {"Luigi Galvani", "Alessandro Volta", "André M. Ampére", "Alfred Nobel"}, // 1939 je spravne [1]
        {"Electronic Arts", "Ubisoft", "SunMicrosystem", "Oracle"}, //Oracle je spravne[3] 
        {"Wide Width Wickets", "Western World Word", "World Wide Web", "Worldwide Weather"},//Spisovatelka je spravne [2]
        {"Android", "iOS", "Windows", "Black BerryOS"},//Vápník spravně [0]
        {"Hermann Fegelein", "Mark Zuckerberg", "Jeff Bezos", "Andrej Babiš"}, //[1]
        {"File triplijng power", "Fast total procesing", "File transfer protocol", "Free transistor protocol"},//[2]
        {"PRC", "GPU", "RAM", "CPU"},//[3]
        {"Rybka", "Megatron Ultra", "CDC 6600", "Sierra"},//[2]
        {"1998", "1995", "1989", "2004"},//[0]
        {"Vladimír Vand", "Josef Šediva", "Vladimír List", "Otto Wichterle"},//[3]
        {"Neo", "Dark Blue", "Deep Blue", "Schah Master"},//[2]
        {"Po dceři majitele", "Po matce majitele", "Po ženě majitele", "Po synu majitele"},//[0]
        {"Ve středověku", "V době bronzové", "V době železné", "V době kamenné"},//[1]
        {"1989", "1990", "1983", "1973"},//[3]
        {"Viktor Kaplan", "Petr Kaplan", "Kaplan Novák", "Kaplan Němec"},//[0]
        {"Z hlíny", "Z hliníku", "Z vinilu", "Z ocely"},//[2]
    };

    String[] poleOtazekHistorie = new String[]{
        "Jak se jmenoval první československý prezident?",//[0]
        "Ve kterém roce skončila druhá světová válka?",//[1]
        "Kolik manželek měl Karel IV.?",//[2]
        "Kdo byl upálen v Kostnici?",//[3]
        "Kdo přivedl Slovany na naše území?",//[4]
        "Která stavba krátce po svém otevření vyhořela? ",//[5]
        "Jaká hora je spojena s příchodem praotce čecha?",//[6]
        "Kdo nechal zabít sv. Václava?",//[7]
        "Kdo vyvolal druhou světovou válku?",//[8]
        "Kam byl vyhoštěn Napoleon Bonaparte?",//[9]
        "Kdy se narodil prorok Mohamed?",//[10]
        "Kdo tuto větu použil „Neruš mé kruhy“?",//[11]
        "Kdo vedl bojovníky v bitvě u Thermopil",//[12]
        "Kde vznikla demokracie?",//[13]
        "Jak se jmenuje první dochovaný zákoník?",//[14]
        "Kdy ke krachu na New Yorcksé burze?",//[15]
        "Co řekl Diogenes Alexandu Velikému při jejich setkání?",//[16]
    };

    String[][] poleOdpovediHistorie = new String[][]{
        {"T.G. Masarik", "Eduard Beneš", "Václav Havel", "Václav Klaus"},//spravne [0]
        {"1948", "1945", "1918", "1939"},//spravne [1]
        {"Žádnou", "6 manželek", "3 manželky", "4 manželky"},//spravne [3] 
        {"Tycho De Brahe", "Jan Žiška", "Jan Hus", "Jan Kepler"},//spravne [2]
        {"Praotec Čech", "Kněžna Libuše", "Kníže Krok", "Kupec Sámo"},//spravně [0]
        {"Valdštejnský Palác", "Národní divadlo", "Národní Muzeum", "Chrám sv. Víta"},//[1]
        {"Praděd", "Klínovec", "Říp", "Sněžka"},//[2]
        {"Jeho matka", "Jeho strýc", "Frencký Král", "Jeho bratr"},//[3]
        {"Neville Chamberlain", "Josef Stalin", "Adolf Hitler", "Benito Mussolini"},//[2]
        {"Ostrov Svatá Helena", "Malajsie", "Rusko", "S. Amerika"},//[0]
        {"1148 n.l.", "571 př.n.l.", "0 n.l", "571 n.l."},//[3]
        {"Alexandr Veliký", "Sofoklés", "Archimédés", "Ježíš Kristus"},//[2]
        {"Leónidás I.", "Themistoklés", "Miltiadés", "Leónidás II."},//[0]
        {"V Istambulu", "V  Athénách", "V Konstantinopoly", "V  Římě"},//[1]
        {"Římský zákoník", "Athénina Listina", "Desatero přikázání", "Chammurapiho zákoník"},//[3]
        {"24. 10. 1929", "24. 10. 1919", "24. 12. 1953", "10. 10. 1919"},//[0]
        {"Nic", "Trojuhelníky vše vyřeší", "Odstup mi ze slunce.", "Neruš moje kruhy"},//[2]
    };

    String[] poleOtazekVseobecne = new String[]{
        "Jak se jmenovali Vikingské lodě?",//[0]
        "Jak se česky nazývá prvek Calcium?",//[1]
        "Kdo je řeckým bohem podsvětí?",//[2]
        "Kdo je Božena Němcová?",//[3]
        "Kde se narodil Albert Einstein?",//[4]
        "Co ti umožňuje cítit bolest?",//[5]
        "Co je advent?",//[6]
        "Které město je hlavním městem Australie?",//[7]
        "Kdo jmenuje v České republice soudce?",//[8]
        "Jaká je přibližně rozloha Česka?",//[9]
        "Kdy zemřel Karel Gott?",//[10]
        "Kolik měří nejvyšší přírodní bod Česka?",//[11]
        "Která budova je nejvyšší  v Česku?",//[12]
        "Jaká je celková délka hranic České republiky?",//[13]
        "Který kraj má nevětší rozlohu? ",//[14]
        "Jaký je náš nejteplejší minerální pramen? ",//[15]
        "Který náš národní park je největší?",//[16]
    };
    String[][] poleOdpovediVseobecne = new String[][]{
        {"Drakary", "Vraky", "Dračí lodě", "Fregaty"},//spravne [0]
        {"Železo", "Vápník", "Síra", "Vodík"},//spravne [1]
        {"Erós", "Héra", "Héfaistos", "Hádés"},//spravne [3] 
        {"Německá politička", "Aktivistka", "Spisovatelka", "Režisérka"},//spravne [2]
        {"V Německu", "V Americe", "V Rakousku", "V Belgii"},//spravně [0]
        {"Kůže", "Nervová zakončení", "Svaly", "Kosti"},//[1]
        {"Programovací jazyk", "Prázdniny", "Doba před vánoci", "Silvestr"},//[2]
        {"Londýn", "Sydney", "Melbourne", "Canberra"},//[3]
        {"Starosta okresu", "Ministr vnitra ", "Prezident republiky", "Premiér"},//[2]
        {"79 000 km2", "140 446 km²", "57 000 km2", "119 000 km2"},//[0]
        {"1. října 2018", "1. října 2020", "17. ledna 2019", "1. října 2019"},//[3]
        {"1503 m n. m.", "1703 m n. m.", "1603 m n. m.", "1653 m n. m."},//[2]
        {"AZ Tower", "V Tower", "City Tower", "City Empiria"},//[0]
        {"1990 km", "2290 km", "3290 km", "2340 km"},//[1]
        {"Pardubický", "Liberecký", "Plzeňský", "Středočeský"},//[3]
        {"Karlovarské vřídlo", "Teplické vřídlo", "Ostravské vřídlo", "Liberecké vřídlo"},//[0]
        {"Podijí", "České Švýcarsko", "Krkonošský", "Šumavský"},//[2]
    };
    Image koruna = new Image(getClass().getResourceAsStream("koruna.png"));
    Image stribrnyPohar = new Image(getClass().getResourceAsStream("stribrnyPohar.png"));
    Image bronzovyPohar = new Image(getClass().getResourceAsStream("bronzovyPohar.png"));
    Image knihy = new Image(getClass().getResourceAsStream("knihy.png"));

    RotateTransition rotaceTam;
    ScaleTransition zmenaVelikosti;

    AudioClip zvukHudby = new AudioClip(this.getClass().getResource("hudbanapozadi2.mp3").toString());

    private MediaPlayer mp;
    private Media me;

    public int cas;

    float sec;

    public long start;
    public long end;

    public String ubehlyCasString;

    int vyberSady = 0;

    public double hlasitost = 1;
    public int hlasitostInt = (int) hlasitost;

    public int pocetOtazek = poleOtazekTechnika.length;

    public int cisloOtazky = 0;
    public double cisloOtazkyDouble = 0;

    public int score = 0;
    public String scoreString = String.valueOf(score);
    int pocetSpatnych = 0;

    int kolikataOtazka = 0;

    Random rand = new Random();

    @FXML
    private AnchorPane hlavniPane;

    @FXML
    private Label scoreText;

    @FXML
    private Button odpoved0;

    @FXML
    private Button odpoved1;

    @FXML
    private Button odpoved2;

    @FXML
    private Button odpoved3;

    @FXML
    private TextField poleOtazky;

    @FXML
    private ProgressBar postupovaLista;

    @FXML
    private Button tlacitkoStart;

    @FXML
    private PieChart grafOdpovedi;

    @FXML
    private Button tlacitkoTematu;

    @FXML
    private Slider nastaveniZvuku;

    @FXML
    private Label ukazatelHlasitosti;

    @FXML
    private ImageView obrazek;

    @FXML
    private Label labelVysledku;

    @FXML
    private Button ulozitVysledek0;

    @FXML
    private TextField ulozeneScore0;

    @FXML
    private TextField ulozenyCas0;

    @FXML
    private Button ulozitVysledek1;

    @FXML
    private TextField ulozeneScore1;

    @FXML
    private TextField ulozenyCas1;

    @FXML
    private Button ulozitVysledek2;

    @FXML
    private TextField ulozeneScore2;

    @FXML
    private TextField ulozenyCas2;

    @FXML
    private Button ulozitVysledek3;

    @FXML
    private TextField ulozeneScore3;

    @FXML
    private TextField ulozenyCas3;

    @FXML
    private Button ulozitVysledek4;

    @FXML
    private TextField ulozeneScore4;

    @FXML
    private TextField ulozenyCas4;

    @FXML
    private Label labelVelkeVysledky;

    @FXML
    private HBox HBoxVysledku;

    @FXML
    void zmacknutoUlozit0(ActionEvent event) {
        ulozeneScore0.setText(scoreString + "/10");
        ulozenyCas0.setText(ubehlyCasString + "sec");
    }

    @FXML
    void zmacknutoUlozit1(ActionEvent event) {
        ulozeneScore1.setText(scoreString + "/10");
        ulozenyCas1.setText(ubehlyCasString + "sec");
    }

    @FXML
    void zmacknutoUlozit2(ActionEvent event) {
        ulozeneScore2.setText(scoreString + "/10");
        ulozenyCas2.setText(ubehlyCasString + "sec");
    }

    @FXML
    void zmacknutoUlozit3(ActionEvent event) {
        ulozeneScore3.setText(scoreString + "/10");
        ulozenyCas3.setText(ubehlyCasString + "sec");
    }

    @FXML
    void zmacknutoUlozit4(ActionEvent event) {
        ulozeneScore4.setText(scoreString + "/10");
        ulozenyCas4.setText(ubehlyCasString + "sec");
    }

    public void zobrazObrazek(Image obrazek1) {
        obrazek.setImage(obrazek1);
    }

    @FXML
    void zmacknutoStart(ActionEvent event) {
        nahodnaDalsiOtazka();
        prehrajClick();

        if (kolikataOtazka == 0) { // zacátek hry
            poleOtazky.setVisible(true);
            odpoved0.setVisible(true);
            odpoved1.setVisible(true);
            odpoved2.setVisible(true);
            odpoved3.setVisible(true);
            postupovaLista.setVisible(true);
            grafOdpovedi.setVisible(false);
            tlacitkoTematu.setMouseTransparent(true);
            scoreText.setVisible(true);

            novaOtazka();
            cisloOtazky = intArray[kolikataOtazka];

            scoreText.setText(scoreString + "/" + kolikataOtazka);
            tlacitkoStart.setText("Restart");
            start = System.currentTimeMillis();

        } else if (kolikataOtazka > 0) { // restart hry - obnova promených
            pocetOtazek = poleOtazekTechnika.length;
            cisloOtazky = 0;
            score = 0;
            scoreString = String.valueOf(score);
            cisloOtazkyDouble = 0;
            kolikataOtazka = 0;

            poleOtazky.setText("Po stisknutí tlačítka start začne hra");
            scoreText.setText(scoreString + "/" + kolikataOtazka);
            postupovaLista.setProgress(cisloOtazkyDouble);
            grafOdpovedi.setVisible(false);
            odpoved0.setVisible(false);
            odpoved1.setVisible(false);
            odpoved2.setVisible(false);
            odpoved3.setVisible(false);
            tlacitkoTematu.setMouseTransparent(false);
            obrazek.setVisible(false);
            labelVysledku.setVisible(false);
            labelVelkeVysledky.setVisible(false);
            HBoxVysledku.setVisible(false);

            tlacitkoStart.setText("Start");
        }

    }

    @FXML
    void zmacknuto0(ActionEvent event) {
        if (cisloOtazky == 0 || cisloOtazky == 4 || cisloOtazky == 9 || cisloOtazky == 12 || cisloOtazky == 15 || cisloOtazky == 0) {
            score++;
            prehrajSpravne();
            if (kolikataOtazka != 9) {
                posuvNaDalsiOtazku();
            } else if (kolikataOtazka == 9) {
                konecHry();
            }

        } else if (kolikataOtazka == 9) {
            prehrajSpatne();
            konecHry();

        } else if (cisloOtazky != 0 || cisloOtazky != 4 || cisloOtazky != 9) {
            posuvNaDalsiOtazku();
            prehrajSpatne();
        }

    }

    @FXML
    void zmacknuto1(ActionEvent event) {
        if (cisloOtazky == 1 || cisloOtazky == 5 || cisloOtazky == 13) {
            score++;
            prehrajSpravne();
            if (kolikataOtazka != 9) {
                posuvNaDalsiOtazku();
            } else if (kolikataOtazka == 9) {
                konecHry();
            }

        } else if (kolikataOtazka == 9) {
            konecHry();
            prehrajSpatne();
        } else if (cisloOtazky != 0 || cisloOtazky != 4 || cisloOtazky != 9) {
            posuvNaDalsiOtazku();
            prehrajSpatne();
        }

    }

    @FXML
    void zmacknuto2(ActionEvent event) {
        if (cisloOtazky == 3 || cisloOtazky == 6 || cisloOtazky == 8 || cisloOtazky == 11 || cisloOtazky == 16) {
            score++;
            prehrajSpravne();
            if (kolikataOtazka != 9) {
                posuvNaDalsiOtazku();
            } else if (kolikataOtazka == 9) {
                konecHry();
            }

        } else if (kolikataOtazka == 9) {
            konecHry();
            prehrajSpatne();
        } else if (cisloOtazky != 0 || cisloOtazky != 4 || cisloOtazky != 9) {
            posuvNaDalsiOtazku();
            prehrajSpatne();
        }

    }

    @FXML
    void zmacknuto3(ActionEvent event) {
        if (cisloOtazky == 2 || cisloOtazky == 7 || cisloOtazky == 10 || cisloOtazky == 14) {
            score++;
            prehrajSpravne();
            if (kolikataOtazka != 9) {
                posuvNaDalsiOtazku();
            } else if (kolikataOtazka == 9) {
                konecHry();
            }

        } else if (kolikataOtazka == 9) {
            konecHry();
            prehrajSpatne();
        } else if (cisloOtazky != 0 || cisloOtazky != 4 || cisloOtazky != 9) {
            posuvNaDalsiOtazku();
            prehrajSpatne();
        }

    }

    @FXML
    void zmenaTematu(ActionEvent event) {
        prehrajClick();
        if (vyberSady == 0) {//0
            vyberSady++;
            tlacitkoTematu.setText("Historicke");

        } else if (vyberSady == 1) {//1
            vyberSady++;
            tlacitkoTematu.setText("Vseobecne");

        } else if (vyberSady == 2) {//2
            vyberSady++;
            tlacitkoTematu.setText("Nahodne");

        } else if (vyberSady == 3) {//3

            tlacitkoTematu.setText("Technicke");
            vyberSady = 0;
        }
    }

    public void novaOtazka() {
        if (vyberSady == 0) {
            poleOtazky.setText(poleOtazekTechnika[intArray[kolikataOtazka]]);
            odpoved0.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][0]);
            odpoved1.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][1]);
            odpoved2.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][2]);
            odpoved3.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][3]);

        } else if (vyberSady == 1) {
            poleOtazky.setText(poleOtazekHistorie[intArray[kolikataOtazka]]);
            odpoved0.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][0]);
            odpoved1.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][1]);
            odpoved2.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][2]);
            odpoved3.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][3]);

        } else if (vyberSady == 2) {
            poleOtazky.setText(poleOtazekVseobecne[intArray[kolikataOtazka]]);
            odpoved0.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][0]);
            odpoved1.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][1]);
            odpoved2.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][2]);
            odpoved3.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][3]);
        } else if (vyberSady == 3) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1); //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

            if (randomNum == 0) {
                poleOtazky.setText(poleOtazekTechnika[intArray[kolikataOtazka]]);
                odpoved0.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][0]);
                odpoved1.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][1]);
                odpoved2.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][2]);
                odpoved3.setText(poleOdpovediTechnika[intArray[kolikataOtazka]][3]);

            } else if (randomNum == 1) {
                poleOtazky.setText(poleOtazekHistorie[intArray[kolikataOtazka]]);
                odpoved0.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][0]);
                odpoved1.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][1]);
                odpoved2.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][2]);
                odpoved3.setText(poleOdpovediHistorie[intArray[kolikataOtazka]][3]);

            } else if (randomNum == 2) {
                poleOtazky.setText(poleOtazekVseobecne[intArray[kolikataOtazka]]);
                odpoved0.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][0]);
                odpoved1.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][1]);
                odpoved2.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][2]);
                odpoved3.setText(poleOdpovediVseobecne[intArray[kolikataOtazka]][3]);
            }
        }
    }

    public void posuvNaDalsiOtazku() {

        kolikataOtazka++;

        cisloOtazky = intArray[kolikataOtazka];
        cisloOtazkyDouble = cisloOtazkyDouble + 0.1;
        novaOtazka();
        postupovaLista.setProgress(cisloOtazkyDouble);
        scoreString = String.valueOf(score);
        scoreText.setText(scoreString + "/" + kolikataOtazka);
    }

    public void konecHry() {
        end = System.currentTimeMillis();
        sec = (end - start) / 1000;
        poleOtazky.setText("Konec Hry");
        ubehlyCasString = String.valueOf(sec);

        cisloOtazkyDouble = cisloOtazkyDouble + 0.1;

        postupovaLista.setProgress(cisloOtazkyDouble);

        scoreString = String.valueOf(score);
        scoreText.setText(scoreString + "/10");// kdyby více nez 10 otázek treba opravit (scoreString + "/" + pocetOtazek)

        pocetSpatnych = 10 - score;

        grafOdpovedi.setVisible(true);

        ObservableList<PieChart.Data> pieChartData //https://docs.oracle.com/javafx/2/charts/pie-chart.htm
                = FXCollections.observableArrayList(
                        new PieChart.Data("Spravně " + score, score),
                        new PieChart.Data("Špatně " + pocetSpatnych, pocetSpatnych));

        grafOdpovedi.setData(pieChartData);
        grafOdpovedi.setStartAngle(90);

        odpoved0.setVisible(false);
        odpoved1.setVisible(false);
        odpoved2.setVisible(false);
        odpoved3.setVisible(false);
        postupovaLista.setVisible(false);
        poleOtazky.setVisible(false);
        labelVelkeVysledky.setVisible(true);
        labelVelkeVysledky.setText(scoreString + "/10");
        scoreText.setVisible(false);
        HBoxVysledku.setVisible(true);

        if (score == 10) {
            obrazek.setVisible(true);
            labelVysledku.setVisible(true);
            zobrazObrazek(koruna);
            animaceToceni(obrazek);
            labelVysledku.setText("Úžasný výkon bezchybný králi Quizů!");
        } else if (pocetSpatnych == 1) {
            obrazek.setVisible(true);
            labelVysledku.setVisible(true);
            zobrazObrazek(stribrnyPohar);
            animaceToceni(obrazek);
            labelVysledku.setText("Chybička se vloudila i tak ale skvělí výkon mistře Quizu!");
        } else if (pocetSpatnych == 2 || pocetSpatnych == 3 || pocetSpatnych == 4) {
            obrazek.setVisible(true);
            labelVysledku.setVisible(true);
            zobrazObrazek(bronzovyPohar);
            animaceToceni(obrazek);
            labelVysledku.setText("Průměrný výkon, cvič ať se staneš Mistrem Quizu!");
        } else if (pocetSpatnych >= 5) {
            obrazek.setVisible(true);
            labelVysledku.setVisible(true);
            zobrazObrazek(knihy);
            animaceToceni(obrazek);
            labelVysledku.setText("Chabý výkon, vrat se až si oprášíš znalosti!");
        }

    }

    public void nahodnaDalsiOtazka() { //https://www.journaldev.com/32661/shuffle-array-java

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);

        //System.out.println(Arrays.toString(intArray));
    }

    // zvuky
    public void prehrajSpatne() {
        AudioClip zvuk1 = new AudioClip(this.getClass().getResource("spatne1.mp3").toString());
        zvuk1.setVolume(hlasitost / 10);
        zvuk1.play();
    }

    public void prehrajSpravne() {
        AudioClip zvuk1 = new AudioClip(this.getClass().getResource("spravneZvonek1.mp3").toString());
        zvuk1.setVolume(hlasitost / 10);
        zvuk1.play();
    }

    public void prehrajClick() {
        AudioClip zvuk1 = new AudioClip(this.getClass().getResource("clicknuti.mp3").toString());
        zvuk1.setVolume(hlasitost / 10);
        zvuk1.play();
    }

    //zvuky
    //animace
    public void animaceToceni(ImageView obraz) {

        rotaceTam = new RotateTransition();
        rotaceTam.setNode(obraz);
        rotaceTam.setDuration(Duration.millis(1500));
        //rotaceTam.setInterpolator(Interpolator.LINEAR);
        rotaceTam.setCycleCount(TranslateTransition.INDEFINITE);
        rotaceTam.setByAngle(360);
        rotaceTam.setAxis(Rotate.Z_AXIS);
        rotaceTam.playFromStart();

        zmenaVelikosti = new ScaleTransition();
        zmenaVelikosti.setNode(obraz);
        zmenaVelikosti.setDuration(Duration.millis(750));
        zmenaVelikosti.setCycleCount(TranslateTransition.INDEFINITE);
        //zmenaVelikosti.setInterpolator(Interpolator.LINEAR);
        zmenaVelikosti.setByX(0.2);
        zmenaVelikosti.setByY(0.2);
        zmenaVelikosti.setAutoReverse(true);
        zmenaVelikosti.playFromStart();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {// https://www.youtube.com/watch?v=X9mEBGXX3dA&t=302s překonvertováno na lambda...

        String path = new File("src\\testvedomostniquiz\\hudbanapozadi2.mp3").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        nastaveniZvuku.setValue(mp.getVolume() * 100);
        mp.play();
        nastaveniZvuku.valueProperty().addListener((javafx.beans.Observable observable) -> {
            mp.setVolume(nastaveniZvuku.getValue() / 100);
        });

        nastaveniZvuku.valueProperty().addListener((ObservableValue<? extends Number> arg2, Number arg3, Number arg4) -> {
            hlasitost = (int) nastaveniZvuku.getValue();
            hlasitostInt = (int) hlasitost;
            ukazatelHlasitosti.setText(hlasitostInt + "/10");
        });

    }

}
