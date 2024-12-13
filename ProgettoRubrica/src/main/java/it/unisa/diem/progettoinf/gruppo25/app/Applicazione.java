package it.unisa.diem.progettoinf.gruppo25.app;
import it.unisa.diem.progettoinf.gruppo25.model.Rubrica;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @brief La classe Applicazione è la classe principale dell'applicazione JavaFX.
 *
 * Questa classe estende la classe di JavaFX e funge da punto di ingresso per l'applicazione.
 * Nel metodo main viene gestito il ciclo di vita dell'applicazione tramite il metodo start.
 */
public class Applicazione extends Application {
    private static Scene scene;
    public static  Rubrica rubricaCondivisa = new Rubrica();
    
    public static Rubrica getRubricaCondivisa() {
        return rubricaCondivisa;
    }

    public static void setRubricaCondivisa(Rubrica rubrica) {
       rubricaCondivisa=rubrica;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
    }

    /**
     * @brief Metodo principale per la creazione e visualizzazione dell'interfaccia grafica.
     * @param[in] primaryStage Rappresenta la finestra principale dell'applicazione.
     *
     * Questo metodo viene invocato automaticamente dal framework JavaFX quando l'applicazione viene avviata.
     * Qui si definisce l'interfaccia grafica dell'applicazione, inclusi i controlli, scene e layout.
     * In questa implementazione, il metodo non è ancora supportato, lancia un'eccezione non supportata.
     *
     * @throws Exception Se si verifica un errore durante l'inizializzazione dell'interfaccia grafica.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
   
        scene = new Scene(loadFXML("ElencoView"), 640, 480);
    
    }
    
    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applicazione.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
