package it.unisa.diem.progettoinf.gruppo25.controller;
import it.unisa.diem.progettoinf.gruppo25.model.Contatto;
import java.util.List;
import it.unisa.diem.progettoinf.gruppo25.view.ElencoView;

/**
 * @class ElencoController
 * @brief Gestisce la logica applicativa per l'elenco dei contatti.
 *
 * Comunica con il Modello per gestire l'elenco completo dei contatti e con la View
 * per mostrarli o ricevere input dall'utente.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */

 public class ElencoController {
    private List<Contatto> elenco;
    private ElencoView elencoView;

    /**
     * @brief Costruttore della classe.
     * @param[in]elenco L'elenco dei contatti da gestire.
     * @param[in] elencoView La vista associata all'elenco.
     */
    public ElencoController(List<Contatto> elenco, ElencoView elencoView) {

    }


}
