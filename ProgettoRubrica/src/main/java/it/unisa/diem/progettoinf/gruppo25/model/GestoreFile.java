/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;
import java.util.List;
import java.io.*;

/**
 * @class GestoreFile
 *
 * @brief Classe per leggere e scrivere dati da e verso file CSV.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */
public class GestoreFile {

    /**
     * @brief Legge un file CSV e restituisce una lista di contatti.
     *
     * Questo metodo legge il contenuto di un file CSV specificato dal parametro `filename`
     * e lo converte in una lista di oggetti della classe `Contatto`.
     *
     * @pre Il file specificato da `filename` deve esistere e deve essere di tipo CVS.
     * @post Se l'operazione ha successo, viene restituita una lista di contatti non nulla.
     *
     * @param[in] filename Nome del file CSV da leggere.
     * @return Lista di contatti letta dal file CSV.
     */
    public List<Contatto> leggiCSV(String filename) throws IOException {
        return null;
    }

    /**
     * @brief Scrive una lista di contatti in un file CSV.
     *
     * Questo metodo salva una lista di oggetti `Contatto` in un file CSV specificato dal parametro `filename`.
     *
     * @pre La lista `rubrica` non deve essere nulla.
     * @post Se l'operazione ha successo, il file `filename` contiene i dati della lista `rubrica` in formato CSV.
     *
     * @param[inout] filename Nome del file CSV in cui scrivere i dati.
     * @param[in] rubrica Lista di contatti da salvare nel file CSV.
     */
    public void scriviCSV(String filename, List<Contatto> rubrica) throws IOException {

    }
}
