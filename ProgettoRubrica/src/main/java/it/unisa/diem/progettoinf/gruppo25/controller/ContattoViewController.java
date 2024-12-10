/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author antoniofedullo
 */
public class ContattoViewController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private HBox hbox;
    @FXML
    private Button btnIndietro;
    @FXML
    private Label lblTitolo;
    @FXML
    private Button btnSalva;
    @FXML
    private GridPane campoDati;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblCognome;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField tfdNome;
    @FXML
    private TextField tfdNumero1;
    @FXML
    private TextField tfdCognome;
    @FXML
    private TextField tfdNumero2;
    @FXML
    private TextField tfdNumero3;
    @FXML
    private TextField tfdEmail1;
    @FXML
    private TextField tfdEmail3;
    @FXML
    private TextField tfdEmail2;
    @FXML
    private Button btnPreferiti;
    @FXML
    private Button btnElimina;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
