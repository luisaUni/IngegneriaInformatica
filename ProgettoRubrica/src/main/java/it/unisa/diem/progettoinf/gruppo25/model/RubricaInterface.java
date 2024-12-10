/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;
import java.util.List;


/**
 * @class RubricaInterface
 * @brief Interfaccia per la gestione di una rubrica di contatti.
 *
 * Questa interfaccia definisce le operazioni principali per gestire una rubrica,
 * come aggiungere, eliminare, cercare e ordinare i contatti.
 */
public interface RubricaInterface {

    /**
     * @brief Aggiunge un contatto alla rubrica.
     *
     * @pre Il contatto `c` non deve essere nullo.
     *
     * @post Il contatto `c` viene aggiunto alla rubrica se non è già presente.
     *
     * @param[in] c Contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto c);

    /**
     * @brief Elimina un contatto dalla rubrica.
     *
     * @pre Il contatto `c` deve esistere nella rubrica.
     * @post Il contatto `c` viene rimosso dalla rubrica.
     *
     * @param[in] c Contatto da eliminare.
     */
    public void eliminaContatto(Contatto c);

    /**
    * @brief Cerca un contatto dalla rubrica attraverso una stringa/sottostringa e ritorna una lista con i contatti che rispecchiano la ricerca.
    * @pre La stringa 's' non deve essere nulla e deve essere una stringa che verrà cercata tra gli attributi (nome,cognome) dei contatti.
    * @post Restituisce una lista di contatti che contengono la stringa 's' in uno dei loro attributi (nome, cognome).
    *
    * @param[in] s La stringa da cercare.
    * @return Una lista di oggetti che contengono la stringa 's' nei loro attributi.
    */

    public List<Contatto> cercaContatto(String s);

    /**
     * @brief Ordina i contatti nella rubrica.
     *
     * @pre La rubrica non deve essere vuota.
     * @post I contatti nella rubrica sono ordinati secondo il criterio specificato.
     *
     * @param[in] e Rubrica da ordinare.
     */
    public void ordina();
}
