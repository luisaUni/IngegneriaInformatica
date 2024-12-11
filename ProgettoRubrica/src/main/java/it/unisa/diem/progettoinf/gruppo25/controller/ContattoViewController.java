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
    private TextField txtNumeri;
    @FXML
    private VBox VboxE;
    @FXML
    private HBox HboxE;
    @FXML
    private Button btnPiuE;
    @FXML
    private TextField textEmail;
    @FXML
    private HBox Hbox4;
    @FXML
    private Button btnSalva;
    @FXML
    private Button btnAnnulla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
