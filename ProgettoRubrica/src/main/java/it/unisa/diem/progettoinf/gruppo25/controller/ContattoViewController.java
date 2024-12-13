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
     
    private Rubrica rubrica;
    private Contatto contatto;
    
    private static Contatto contattoSelezionato;
    private static boolean isNuovoContatto;

    public static void setContattoSelezionato(Contatto contatto) {
        contattoSelezionato = contatto;
    }

    public static void setNuovoContatto(boolean nuovo) {
        isNuovoContatto = nuovo;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rubrica= Applicazione.getRubricaCondivisa();
        if (isNuovoContatto) {
        contatto = new Contatto();
        } else if (contattoSelezionato != null) {
            contatto = contattoSelezionato;
        }
        
        if (contatto!=null) {
            txtNome.setText(contatto.getNome());
            txtCognome.setText(contatto.getCognome());
            textNumero.setText(contatto.getNumero1() != null ? contatto.getNumero1() : "");
            textEmail.setText(contatto.getEmail1() != null ? contatto.getEmail1() : "");
        } 
       
        if (contatto.getNumero2() != null && !contatto.getNumero2().isEmpty()) {
            TextField num2Field = new TextField(contatto.getNumero2());
            num2Field.setPromptText("Numero aggiuntivo");
            containerNum.getChildren().add(num2Field);
        }
        if (contatto.getNumero3() != null && !contatto.getNumero3().isEmpty()) {
            TextField num3Field = new TextField(contatto.getNumero3());
            num3Field.setPromptText("Numero aggiuntivo");
            containerNum.getChildren().add(num3Field);
        }

        if (contatto.getEmail2() != null && !contatto.getEmail2().isEmpty()) {
            TextField email2Field = new TextField(contatto.getEmail2());
            email2Field.setPromptText("Email aggiuntiva");
            containerEmail.getChildren().add(email2Field);
        }
        if (contatto.getEmail3() != null && !contatto.getEmail3().isEmpty()) {
            TextField email3Field = new TextField(contatto.getEmail3());
            email3Field.setPromptText("Email aggiuntiva");
            containerEmail.getChildren().add(email3Field);
        }
        
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
