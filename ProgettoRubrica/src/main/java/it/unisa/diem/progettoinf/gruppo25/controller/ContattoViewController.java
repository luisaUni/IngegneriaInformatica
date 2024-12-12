/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.controller;

import it.unisa.diem.progettoinf.gruppo25.app.Applicazione;
import it.unisa.diem.progettoinf.gruppo25.model.Contatto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author luisacrivo
 */
public class ContattoViewController implements Initializable {
    @FXML
    private AnchorPane Schermo;
    @FXML
    private HBox Hbox1;
    @FXML
    private Button btnIndietro;
    @FXML
    private Label lblTitolo;
    @FXML
    private Button btnSalva;
    @FXML
    private GridPane grid;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblnumeri;
    @FXML
    private TextField txtNome;
    @FXML
    private Label lblcognome;
    @FXML
    private TextField txtCognome;
    @FXML
    private Label lblemail;
    @FXML
    private VBox VboxN;
    @FXML
    private HBox HboxN;
    @FXML
    private Button btnPiuN;
    @FXML
    private VBox containerNum;
    @FXML
    private TextField textNumero;
    @FXML
    private VBox VboxE;
    @FXML
    private HBox HboxE;
    @FXML
    private Button btnPiuE;
    @FXML
    private VBox containerEmail;
    @FXML
    private TextField textEmail;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    
    @FXML
    private void switchToPrimary(ActionEvent event) {
      try {
        Applicazione.setRoot("ElencoView");
    } catch (IOException e) {
        System.err.println("Errore nel cambio vista: " + e.getMessage());
      }
    
}
    @FXML
    private void aggiungiNum(ActionEvent event) {
    int count = containerNum.getChildren().size();

    if (count >= 3) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Limite superato");
        alert.setHeaderText("Non puoi aggiungere altri campi");
        alert.setContentText("È consentito un massimo di 3 numeri di telefono.");
        alert.showAndWait();
    } else {
        TextField nuovoTextField = new TextField();
        nuovoTextField.setPromptText("Aggiungi numero");
        containerNum.getChildren().add(nuovoTextField);
    }
    }
    
    @FXML
    private void aggiungiEmail(ActionEvent event) {
    
      int count= containerEmail.getChildren().size();
      
      if(count>=3){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Limite superato");
        alert.setHeaderText("Non puoi aggiungere altri campi");
        alert.setContentText("È consentito un massimo di 3 indirizzi e-mail.");
        alert.showAndWait();
      } else {
          TextField nuovoTextField = new TextField();
          nuovoTextField.setPromptText("Aggiungi email");
          containerEmail.getChildren().add(nuovoTextField);
      }
    }
    
    
}
