package it.unisa.diem.progettoinf.gruppo25.app;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * @brief La classe Applicazione è la classe principale dell'applicazione JavaFX.
 *
 * Questa classe estende la classe {@link Application} di JavaFX e funge da punto di ingresso per l'applicazione.
 * Nel metodo main viene gestito il ciclo di vita dell'applicazione tramite il metodo {@link start}.
 */
public class Applicazione extends Application {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
