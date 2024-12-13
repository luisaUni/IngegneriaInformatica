/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.diem.progettoinf.gruppo25.app.Applicazione;
import it.unisa.diem.progettoinf.gruppo25.model.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author francescadepascale
 */
public class ElencoViewController implements Initializable {
    @FXML
    private AnchorPane latoSinistro;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem btnImporta;
    @FXML
    private MenuItem btnEsporta;
    @FXML
    private MenuItem btnCrea;
    @FXML
    private ImageView imgLente;
    @FXML
    private TextField fieldCerca;
    @FXML
    private TableView<Contatto> tableElenco;
    @FXML
    private TableColumn<Contatto, String> colonnaNome;
    @FXML
    private TableColumn<Contatto, String> colonnaCognome;
    @FXML
    private TableColumn<Contatto, String> colonnaPreferiti;
    @FXML
    private AnchorPane latoDestro;
    @FXML
    private Label titoloContatto;
    @FXML
    private GridPane grigliaContatto;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblCognome;
    @FXML
    private Label lblEmail1;
    @FXML
    private Label lblEmail2;
    @FXML
    private Label lblEmail3;
    @FXML
    private Label lblNumero1;
    @FXML
    private Label lblNumero2;
    @FXML
    private Label lblNumero3;
    @FXML
    private Button btnModifica;
    @FXML
    private Button btnPreferiti;
    @FXML
    private Button btnElimina;
    
    private Rubrica rubrica;
    private ObservableList<Contatto> contatti;
    private FilteredList<Contatto> filteredList; 
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        rubrica = Applicazione.getRubricaCondivisa(); 
        rubrica.ordina();
        ObservableList<Contatto> contattiCondivisi = FXCollections.observableArrayList(rubrica.getContatti());
        filteredList = new FilteredList<>(contattiCondivisi, p -> true);
        colonnaNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        colonnaCognome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCognome()));
        colonnaPreferiti.setCellValueFactory(c -> {
            if (c.getValue() != null) {
                boolean isPreferito = c.getValue().isPreferito();
                return new SimpleStringProperty(isPreferito ? "★" : "");
            }
            return new SimpleStringProperty(""); 
        });
        tableElenco.setItems(filteredList);
        latoDestro.setVisible(false);
        fieldCerca.textProperty().addListener((observable, oldValue, newValue) -> filtraContatti(newValue));   
        tableElenco.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {  
        if (newSelection != null) {
            latoDestro.setVisible(true);
            if (newSelection.getNome() != null) {
                lblNome.setText(newSelection.getNome());
            } else {
                lblNome.setText("");
            }
            
            if (newSelection.getCognome() != null) {
                lblCognome.setText(newSelection.getCognome());
            } else {
                lblCognome.setText("");
            }
            
            if (newSelection.getEmail1() != null) {
                lblEmail1.setText(newSelection.getEmail1());
            } else {
                lblEmail1.setText("");
            }

            if (newSelection.getEmail2() != null) {
                lblEmail2.setText(newSelection.getEmail2());
            } else {
                lblEmail2.setText("");
            }

             if (newSelection.getEmail3() != null) {
                lblEmail3.setText(newSelection.getEmail3());
            } else {
                 lblEmail3.setText("");
            }

            if (newSelection.getNumero1() != null) {
                lblNumero1.setText( newSelection.getNumero1());
            } else {
                lblNumero1.setText("");
            }

            if (newSelection.getNumero2() != null) {
                lblNumero2.setText(newSelection.getNumero2());
            } else {
                lblNumero2.setText("");
            }

            if (newSelection.getNumero3() != null) {
                lblNumero3.setText(newSelection.getNumero3());
            } else {
                lblNumero3.setText("");
            }
        } else {
            latoDestro.setVisible(false);
        }
        });
   } 
    
    private void showContactDetails(Contatto contatto) {
        if (contatto != null) {
            lblNome.setText(contatto.getNome());
            lblCognome.setText(contatto.getCognome());
            lblNumero1.setText(contatto.getNumero1());
            lblNumero2.setText(contatto.getNumero2());
            lblNumero3.setText(contatto.getNumero3());
            lblEmail1.setText(contatto.getEmail1());
            lblEmail2.setText(contatto.getEmail2());
            lblEmail3.setText(contatto.getEmail3());
            
        } else {
            lblNome.setText("");
            lblCognome.setText("");
            lblNumero1.setText("");
            lblNumero2.setText("");
            lblNumero3.setText("");
            lblEmail1.setText("");
            lblEmail2.setText("");
            lblEmail3.setText("");
        }  
    }
    
    
    
        @FXML
    private void handleDeletePerson() {
        int selectedIndex =  tableElenco.getSelectionModel().getSelectedIndex();
            
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Conferma eliminazione");
            confirmationAlert.setHeaderText("Sei sicuro di voler eliminare il contatto?");
            confirmationAlert.setContentText("Questa azione non può essere annullata.");
            // Aggiungi i pulsanti "Conferma" e "Annulla"
            ButtonType confirmButton = new ButtonType("Conferma", ButtonType.OK.getButtonData());
            ButtonType cancelButton = new ButtonType("Annulla", ButtonType.CANCEL.getButtonData());
            confirmationAlert.getButtonTypes().setAll(confirmButton, cancelButton);

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == confirmButton) {
                // Rimuovi il contatto se l'utente conferma
                tableElenco.getItems().remove(selectedIndex);
            }
    }
    
    
    
    @FXML
    private void handleImportCsv() {
    // Crea un pop-up di scelta con due pulsanti
        Alert choiceAlert = new Alert(Alert.AlertType.CONFIRMATION);
        choiceAlert.setTitle("Seleziona Modalità di Importazione");
        choiceAlert.setHeaderText("Come desideri importare i contatti?");
        choiceAlert.setContentText("Scegli una delle opzioni seguenti:");
        ButtonType defaultButton = new ButtonType("Importa da file di Default");
        ButtonType externalButton = new ButtonType("Importa da file Esterno");

        choiceAlert.getButtonTypes().setAll(defaultButton, externalButton);

        Optional<ButtonType> result = choiceAlert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == defaultButton) {
                // Importa da file di default (rubrica.csv)
                importFromDefaultFile();
            } else if (result.get() == externalButton) {
                // Importa da file esterno scelto dall'utente
                importFromExternalFile();
            }
             // Se l'utente sceglie "Annulla", non fare nulla
        }else{
             System.out.println("Nessuna opzione selezionata.");
        }
    }

    private void importFromDefaultFile() {
        try {
            // Percorso del file di default
            
            Rubrica rubrica= GestoreFile.leggiCSV();

            // Aggiungi i contatti alla tabella
            tableElenco.getItems().addAll(rubrica.getContatti());
        } catch (IOException e) {
            showError("Errore durante l'importazione", "Non è stato possibile leggere il file di default.");
            String defaultFile = "rubrica.csv";
   
        }
    }

    private void importFromExternalFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un file CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
             try {
                 // Usa il metodo importa per caricare i dati
                 Rubrica rubrica = GestoreFile.importa(file.getAbsolutePath());

                // Aggiungi i contatti alla tabella
                tableElenco.getItems().addAll(rubrica.getContatti());
            } catch (IOException e) {
            showError("Errore durante l'importazione", "Non è stato possibile leggere il file selezionato.");
            }   
       }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null );
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
     @FXML
    private void handleEsportaCsv() {
    // Crea un pop-up per selezionare la posizione del file di esportazione
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
    fileChooser.setTitle("Salva file CSV");

    // Mostra la finestra di dialogo per salvare il file
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        try {
            // Ottieni la rubrica dalla tabella (o dalla tua struttura di dati)
            ArrayList<Contatto> rubrica = new ArrayList<>(tableElenco.getItems());

            // Chiama il metodo esporta per scrivere i dati nel file
            GestoreFile.esporta(file.getAbsolutePath(), rubrica);

        } catch (IOException e) {
            showError("Errore durante l'esportazione", "Non è stato possibile salvare il file CSV.");
        } catch (IllegalArgumentException e) {
            showError("Errore", e.getMessage());
        }
    }
}
    
    
}
