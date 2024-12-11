/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.controller;

import it.unisa.diem.progettoinf.gruppo25.app.Applicazione;
import it.unisa.diem.progettoinf.gruppo25.model.Contatto;
import it.unisa.diem.progettoinf.gruppo25.model.Rubrica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
    
    private Rubrica contatti;

    @FXML
    private void switchToContattoView() {
    try {
        Applicazione.setRoot("ContattoView");
    } catch (IOException e) {
        System.err.println("Errore nel cambio vista: " + e.getMessage());
    }
}
    
    private void showContactDetails(Contatto contatto) {
        if (contatto != null) {
            // Mostra i dettagli del contatto
            lblNome.setText(contatto.getNome());
            lblCognome.setText(contatto.getCognome());
            lblNumero1.setText(contatto.getNumero1());
            lblNumero2.setText(contatto.getNumero2());
            lblNumero3.setText(contatto.getNumero3());
            lblEmail1.setText(contatto.getEmail1());
            lblEmail2.setText(contatto.getEmail2());
            lblEmail3.setText(contatto.getEmail3());
            
        } else {
            // Cancella i dettagli se nessun contatto è selezionato
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // contatti = FXCollections.observableArrayList();
        contatti = new Rubrica();
        
        colonnaNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        colonnaCognome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCognome()));
        colonnaPreferiti.setCellValueFactory(c -> {
        if (c.getValue() != null) {
        boolean isPreferito = c.getValue().isPreferito();
        return new SimpleStringProperty(isPreferito ? "⭐" : "");
        }
        return new SimpleStringProperty(""); // Gestione in caso di valore nullo
   
       });
        
        latoDestro.setVisible(false);
        
        btnImporta.setOnAction(event -> {
            System.out.println("Importa cliccato!");
        });

        btnEsporta.setOnAction(event -> {
            System.out.println("Esporta cliccato!");
        });

         btnCrea.setOnAction(event -> {
            System.out.println("Crea cliccato!");
            switchToContattoView();
        });
         
        tableElenco.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {  
        if (newSelection != null) {
            latoDestro.setVisible(true);

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
    
    @FXML
    public void aggiungiAiPreferiti(ActionEvent event) {
    Contatto contattoSelezionato = tableElenco.getSelectionModel().getSelectedItem();

    if (contattoSelezionato != null) {
        contattoSelezionato.setPreferito(!contattoSelezionato.isPreferito());
        tableElenco.refresh();
    } else {
        System.out.println("Nessun contatto selezionato.");
    }
}
    
    
}
