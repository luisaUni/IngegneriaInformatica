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
    private TableView<?> tblElenco;
    @FXML
    private TableColumn<?, ?> colonnaNome;
    @FXML
    private TableColumn<?, ?> colonnaCognome;
    @FXML
    private TableColumn<?, ?> colonnaPreferito;
    @FXML
    private TableColumn<?, ?> colonnaInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
