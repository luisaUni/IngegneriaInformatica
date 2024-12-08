
package it.unisa.diem.progettoinf.gruppo25.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @file Rubrica.java
 * @brief Classe per rappresentare e gestire una rubrica di contatti.
 * 
 * Questa classe offre funzionalità per gestire una lista di contatti, 
 * inclusa l'aggiunta, la rimozione, la ricerca e l'ordinamento.
 * 
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */
public class Rubrica {
    private List<Contatto> elenco;

    /**
     * @brief Costruttore di default della classe `Rubrica`.
     * 
     * @post Crea un oggetto `Rubrica` con una lista di contatti vuota.
     */
    public Rubrica(){
        elenco= new ArrayList();
    }


    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * @pre Il contatto `c` non deve essere nullo.
     * 
     * @post Il contatto `c` viene aggiunto alla rubrica se non è già presente.
     * 
     * @param[in] c Contatto da aggiungere.
     */
    public void aggiungiContatto(Contatto c){

    }

    /**
     * @brief Elimina un contatto dalla rubrica.
     * 
     * @pre Il contatto `c` deve esistere nella rubrica.
     * @post Il contatto `c` viene rimosso dalla rubrica.
     * 
     * @param[in] c Contatto da eliminare.
     */
    public void eliminaContatto(Contatto c){

    }

    
    public Contatto cercaContatto(String s){
        return null;

    }

    /**
     * @brief Ordina i contatti nella rubrica.
     * 
     * @pre La rubrica non deve essere vuota.
     * @post I contatti nella rubrica sono ordinati secondo il criterio specificato.
     * 
     * @param[in] e Rubrica da ordinare.
     */
    public void ordina(Rubrica e){

    }
    
    /**
     * @brief Restituisce una rappresentazione testuale della rubrica.
     * 
     * Questo metodo restituisce una stringa che rappresenta i contatti nella rubrica in formato leggibile.
     * 
     * @return Stringa rappresentativa della rubrica.
     */
    @Override
    public String toString(){
        return "";
    }

}
