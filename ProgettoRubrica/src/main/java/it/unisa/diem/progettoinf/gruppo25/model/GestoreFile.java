/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.io.*;

/**
 * @class GestoreFile
 *
 * @brief Classe per leggere e scrivere dati da e verso file CSV.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */
public class GestoreFile {
  private static final String FILE_DEFAULT = "rubrica.csv";

    /**
    * @brief Restituisce un file di default. Il file di default è il file su cui il sistema esegue le operazioni di lettira e scrittura di default.
    * @return File di default.
    */

    public static String getFileDefault() {
        return FILE_DEFAULT;
    }
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
     * @throws IOException Se si verifica un errore durante l'accesso al file.
     */

    // L'utente decide di importare da un file CSV esterno diverso da quello di default.
    public static Rubrica importa(String filename) throws IOException {
      if (filename == null || filename.isBlank()) {
          throw new IllegalArgumentException("Il nome del file non può essere nullo o vuoto.");
      }
        Rubrica r = new Rubrica();
         try(Scanner i = new Scanner(new BufferedReader(new FileReader(filename)))){
            i.useLocale(Locale.US);
            i.useDelimiter(";\n*");

            Contatto c = new Contatto(nome,cognome,numero1,numero2,numero3,email1,email2,email3);
            while(i.hasNext()){
              c.setNome(i.hasNext() ? i.next() : null);
              c.setCognome(i.hasNext() ? i.next() : null);
              c.setNumero1(i.hasNext() ? i.next() : null);
              c.setNumero2(i.hasNext() ? i.next() : null);
              c.setNumero3(i.hasNext() ? i.next() : null);
              c.setEmail1(i.hasNext() ? i.next() : null);
              c.setEmail2(i.hasNext() ? i.next() : null);
              c.setEmail3(i.hasNext() ? i.next() : null);
              r.aggiungiContatto(c);
            }
         }

        return r;
    }

  // L'utente importa dal file CSV di default.
    public static Rubrica leggiCSV() throws IOException{
      return importa(FILE_DEFAULT);
    }

    /**
     * @brief Scrive una lista di contatti nel file CSV di default.
     *
     * Questo metodo salva una lista di oggetti `Contatto` nel file CSV di default.
     *
     * @pre La lista `rubrica` non deve essere nulla.
     * @post Se l'operazione ha successo, il file di default contiene i dati della lista `rubrica` in formato CSV.
     *
     * @param[inout] filename Nome del file CSV in cui scrivere i dati.
     * @param[in] rubrica Lista di contatti da salvare nel file CSV.
     * @throws IOException Se si verifica un errore durante l'accesso al file.
     */
    public static void scriviCSV(ArrayList<Contatto> rubrica) throws IOException {
        esporta(FILE_DEFAULT, rubrica);
    }


    /**
    * @brief Scrive una lista di contatti in un file specificato dal nome 'filename'.
    *
    * Questo metodo salva una lista di oggetti `Contatto` nel file CSV di default.
    * @pre La lista `rubrica` non deve essere nulla.
    * @post Se l'operazione ha successo, il file 'filename' contiene i dati della lista `rubrica` in formato CSV.
    *
    * @param[in] rubrica Lista di contatti da salvare nel file CSV.
    * @throws IOException Se si verifica un errore durante l'accesso al file.
    */
    public static void esporta(String filename, ArrayList<Contatto> rubrica) throws IOException{
      if (rubrica == null || rubrica.isEmpty()) {
        throw new IllegalArgumentException("La rubrica non può essere nulla o vuota.");
    }
      try(PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter(filename)))){

        pw.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3");

        for(Contatto c : rubrica){

          if(c.getNome() != null){
            pw.print(c.getNome());
          }
          pw.append(";");

          if(c.getCognome()!= null){
            pw.print(c.getCognome());
          }
          pw.append(";");

          if(c.getNumero1()!= null){
            pw.print(c.getNumero1());
          }
          pw.append(";");

          if(c.getNumero2()!= null){
              pw.print(c.getNumero2());
          }
          pw.append(";");

          if(c.getNumero3()!= null){
              pw.print(c.getNumero3());
          }
          pw.append(";");

          if(c.getEmail1()!= null){
              pw.print(c.getEmail1());
          }
          pw.append(";");

          if(c.getEmail2()!= null){
              pw.print(c.getEmail2());
          }
          pw.append(";");

          if(c.getEmail3()!= null){
              pw.print(c.getEmail3());
          }
            pw.append("\n");
        }
      }
    }

}
