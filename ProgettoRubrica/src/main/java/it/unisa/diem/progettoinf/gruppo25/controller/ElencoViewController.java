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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author antoniofedullo, francescadepascale, luisacrivo
 */
public class ElencoViewController implements Initializable {

    @FXML
    private AnchorPane latoSinistro;
    @FXML
    private HBox hbox;
    @FXML
    private Button btnIndietro;
    @FXML
    private Label lblTitolo;
    @FXML
    private Button btnSalva;
    @FXML
    private VBox vbox;
    @FXML
    private Label lblNome;
    @FXML
    private TextField fieldNome;
    @FXML
    private Label lblCognome;
    @FXML
    private TextField fieldCognome;
    @FXML
    private Label lblNumero;
    @FXML
    private VBox containerNumeri;
    @FXML
    private HBox containerNumeroAdd;
    @FXML
    private TextField fieldNumero1;
    @FXML
    private Button btnAggiungiNumero;
    @FXML
    private Label lblEmail;
    @FXML
    private VBox containerEmail;
    @FXML
    private HBox containerEmailAdd;
    @FXML
    private TextField fieldEmail1;
    @FXML
    private Button btnAggiungiEmail;
    @FXML
    private Button btnPreferiti;
    @FXML
    private Button btnElimina;
    @FXML
    private AnchorPane latoDestro;
    @FXML
    private VBox VBox;
    @FXML
    private HBox HBox;
    @FXML
    private MenuBar menubar;
    @FXML
    private Menu menu;
    @FXML
    private MenuItem crea;
    @FXML
    private MenuItem importa;
    @FXML
    private MenuItem esporta;
    @FXML
    private Button btnChiudi;
    @FXML
    private HBox containerCerca;
    @FXML
    private ImageView imgCerca;
    @FXML
    private TextField fieldCerca;
    @FXML
    private TableView<?> tblElenco;
    @FXML
    private TableColumn<?, ?> colonnaNome;
    @FXML

    private TableColumn<?, ?> colonnaCognome;
    @FXML
    private TableColumn<?, ?> colonnaPreferito;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
