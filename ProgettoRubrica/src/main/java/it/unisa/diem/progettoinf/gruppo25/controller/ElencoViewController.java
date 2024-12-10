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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author antoniofedullo
 */
public class ElencoViewController implements Initializable {
    @FXML
    private AnchorPane contenitore;
    @FXML
    private VBox VBox;
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
    private TextField tfdCerca;
    @FXML
    private TableView<Contatto> tblElenco;
    @FXML
    private TableColumn<Contatto, String> colonnaNome;
    @FXML
    private TableColumn<Contatto, String> colonnaCognome;
    @FXML
    private TableColumn<Contatto, Void> colonnaPreferito;
    @FXML
    private TableColumn<Contatto, Void> colonnaInfo;

    @FXML
    private void switchToSecondary() throws IOException{
      //Applicazione.setRoot("secondary");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
