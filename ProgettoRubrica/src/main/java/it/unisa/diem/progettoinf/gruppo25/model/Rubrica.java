
package it.unisa.diem.progettoinf.gruppo25.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 *
 * @class Rubrica
 * @brief Classe per rappresentare e gestire una rubrica di contatti.
 *
 * Questa classe offre funzionalità per gestire una lista di contatti,
 *
 * inclusa l'aggiunta, la rimozione, la ricerca e l'ordinamento.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */
public class Rubrica implements RubricaInterface{

     private List<Contatto> elenco;

    /**
     * @brief Costruttore di default della classe `Rubrica`.
     *
     * @post Crea un oggetto `Rubrica` con una lista di contatti vuota.
     */

     public Rubrica(){
        elenco= FXCollections.observableArrayList();
     }
    
     public Rubrica(List<Contatto> contatti) {
        this.elenco = contatti;
    }
     
     
     public List<Contatto> getContatti(){
         return elenco;
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
     @Override
     public void aggiungiContatto(Contatto c) {
       if ((c.getNome() != null && !c.getNome().trim().isEmpty()) || (c.getCognome() != null && !c.getCognome().trim().isEmpty())){
            elenco.add(c);
          }
       else{
          System.out.println("Errore: impossibile inserire contatto con campo nome e cognome vuoto ");
       }
     }



    /**
     * @brief Elimina un contatto dalla rubrica.
     *
     * @pre Il contatto `c` deve esistere nella rubrica.
     * @post Il contatto `c` viene rimosso dalla rubrica.
     *
     * @param[in] c Contatto da eliminare.
     */
     @Override
     public void eliminaContatto(Contatto c){
        if(elenco.remove(c));
     }

    /**
    * @brief Cerca un contatto dalla rubrica attraverso una stringa/sottostringa e ritorna una lista con i contatti che rispecchiano la ricerca.
    * @pre La stringa 's' non deve essere nulla e deve essere una stringa che verrà cercata tra gli attributi (nome,cognome) dei contatti.
    * @post Restituisce una lista di contatti che contengono la stringa 's' in uno dei loro attributi (nome, cognome).
    *
    * @param[in] s La stringa da cercare.
    * @return Una lista di oggetti che contengono la stringa 's' nei loro attributi.
    */

    @Override
    public List<Contatto> cercaContatto(String s){
        List<Contatto> risultati = new ArrayList<>();
        for (Contatto contatto : elenco) {
          if (contatto.getNome().toLowerCase().startsWith(s.toLowerCase()) || contatto.getCognome().toLowerCase().startsWith(s.toLowerCase())) {
            risultati.add(contatto);
          }
        }
        return risultati;
    }



    /**
     * @brief Ordina i contatti nella rubrica.
     *
     * @pre La rubrica non deve essere vuota.
     * @post I contatti nella rubrica sono ordinati secondo il criterio specificato.
     *
     * @param[in] e Rubrica da ordinare.
     */

    @Override
     public void ordina(){
        elenco.sort(null);
     }

    public Comparator<Contatto> getComparator() {
        return Comparator.comparing(Contatto::getCognome).thenComparing(Contatto::getNome);
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
       StringBuilder sb = new StringBuilder();
       for (Contatto contatto : elenco) {
           sb.append(contatto.toString()).append("\n");
       }
       return sb.toString();
    }
    
}
