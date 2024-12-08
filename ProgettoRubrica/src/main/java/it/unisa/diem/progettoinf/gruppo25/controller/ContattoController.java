package it.unisa.diem.progettoinf.gruppo25.controller;
import it.unisa.diem.progettoinf.gruppo25.model.Contatto;
import it.unisa.diem.progettoinf.gruppo25.view.ContattoView;

/**
 * @class ContattoController
 * @brief Gestisce la logica applicativa per un singolo contatto.
 *
 * Comunica con il Modello per aggiornare i dati del contatto e con la View per
 * mostrare o raccogliere informazioni dall'utente.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */


public class ContattoController {
    private Contatto contatto;
    private ContattoView contattoView;

    /**
     * @brief Costruttore della classe.
     * @param[in] contatto Il contatto da gestire.
     * @param[in] contattoView La vista associata al contatto.
     */
    public ContattoController(Contatto contatto, ContattoView contattoView) {

    }

}
