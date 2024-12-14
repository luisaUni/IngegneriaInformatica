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
import javafx.scene.Node;
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

    @FXML
    private void vaiAllElenco(ActionEvent e){
    try {
        Applicazione.setRoot("primary");
    }catch(IOException ex){
        System.err.println("Errore nel cambio vista: " + ex.getMessage());  
    }
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
    private void switchToPrimary() {
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
            showError("Limite superato", "È consentito un massimo di 3 numeri di telefono");  
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
            showError("Limite superato", "È consentito un massimo di 3 indirizzi email");
        } else {
          TextField nuovoTextField = new TextField();
          nuovoTextField.setPromptText("Aggiungi email");
          containerEmail.getChildren().add(nuovoTextField);
        }
    }
    
     private void showError(String title, String message){
        System.out.println("Mostro alert con messaggio: " + message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null );
        alert.setContentText(message);
        alert.showAndWait();
    }
     
    @FXML
    public void aggiungiContatto(){
        if(isInputValid()){
            
            contatto.setNome(txtNome.getText());
            contatto.setCognome(txtCognome.getText());
            contatto.setNumero1(textNumero.getText());
            contatto.setEmail1(textEmail.getText());
            aggiornaNumeri(contatto);
            aggiornaEmail(contatto);
            if (isNuovoContatto) {
                //App.getContatti().add(contatto);
                Applicazione.getRubricaCondivisa().aggiungiContatto(contatto);
            }
            switchToPrimary();
        }
        
    }
    
        private boolean isInputValid() {

        StringBuilder Error= new StringBuilder("");
        if(((txtNome.getText()== null) || txtNome.getText().length() == 0)&&((txtCognome.getText()== null) || txtCognome.getText().length() == 0)) {
            Error.append("Campo nome e cognome contemporanemente vuoti");
        }
        if((!textNumero.getText().isEmpty())&&(!textNumero.getText().matches("\\d+"))){
            Error.append("numero di telefono non valido");
        }
        if ((!textEmail.getText().isEmpty()) && (!textEmail.getText().matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}"))) {
            Error.append("\"Email non valida.\\n\"");
        }
        int numCount = 1;
        for (Node node : containerNum.getChildren()) {
            if (node instanceof TextField) {
                String numero = ((TextField) node).getText().trim();
                if (!numero.isEmpty() && !numero.matches("\\d+")) {
                    Error.append( "Numero aggiuntivo " + numCount + " non valido: " + numero + ".\n");
                }
                
                numCount++;
            }
        }
        int emailCount = 1;
        for (Node node : containerEmail.getChildren()) {
            if (node instanceof TextField) {
                String email = ((TextField) node).getText();
                if ((!email.isEmpty()) && (!email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}"))) {
                    Error.append( " \n Email aggiuntiva  " + emailCount + " non valida: " + email + ".\n");
                }
                emailCount++;
            }
        }
        if (Error.length() > 0) {
            showError("Errore", Error.toString());
            return false; 
        } 
        return true;

    }
          
    private void aggiornaNumeri(Contatto contatto){
        int numCount = 1;
        for (Node node : containerNum.getChildren()) {
            if (node instanceof TextField) {
                String numero = ((TextField) node).getText();
                if (numCount == 2) {
                    if (numero.isEmpty() && contatto.getNumero2() != null) {
                        contatto.setNumero2(null);
                    } else if (!numero.isEmpty()) {
                        contatto.setNumero2(numero);
                    }
                } else if (numCount == 3) {
                    if (numero.isEmpty() && contatto.getNumero3() != null) {
                        contatto.setNumero3(null);
                    } else if (!numero.isEmpty()) {
                        contatto.setNumero3(numero);
                    }
            }

                    numCount++;
                }
            }
        }
    
    
     private void aggiornaEmail(Contatto contatto){
        int emailCount = 1;
        for (Node node : containerEmail.getChildren()) {
            if (node instanceof TextField) {
                String email = ((TextField) node).getText();
                if (emailCount == 2) {
                if (email.isEmpty() && contatto.getEmail2() != null) {
                    contatto.setEmail2(null);
                } else if (!email.isEmpty()) {
                    contatto.setEmail2(email);
                }
            } else if (emailCount == 3) {
                if (email.isEmpty() && contatto.getEmail3() != null) {
                    contatto.setEmail3(null);
                } else if (!email.isEmpty()) {
                    contatto.setEmail3(email);
                }
            }

            emailCount++;
                
            }
        }
    }
     
      
    @FXML
    public void SalvaModifiche(){
        if (isInputValid()) {
        
            contatto.setNome(txtNome.getText());
            contatto.setCognome(txtCognome.getText());
            contatto.setNumero1(textNumero.getText());
            contatto.setEmail1(textEmail.getText());

            aggiornaNumeri(contatto);
            aggiornaEmail(contatto);
            switchToPrimary();
        }
        
    }
    
}
