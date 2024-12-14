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
import java.util.List;
import java.util.Locale;

/**
 * @class GestoreFile
 *
 * @brief Classe per leggere e scrivere dati da e verso file CSV.
 *
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */
public class GestoreFile {
    
    /**
     * @brief Costruttore di default della classe `GestoreFile`.
     *
     * @post Crea un oggetto `GestoreFile` vuoto.
     */
    public GestoreFile(){
        
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


    public   Rubrica importa(String filename) throws IOException {
        if (filename == null) {
            throw new IllegalArgumentException("Il nome del file non può essere nullo.");
        }
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Errore: Il file non esiste: " + filename);
            throw new IOException("Il file non esiste: " + filename);
        }
        List<Contatto> r= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                Contatto c = new Contatto();
                c.setNome(fields.length > 0 ? fields[0].trim() : "");
                c.setCognome(fields.length > 1 ? fields[1].trim() : "");
                c.setNumero1(fields.length > 2 ? fields[2].trim() : "");
                c.setNumero2(fields.length > 3 ? fields[3].trim() : "");
                c.setNumero3(fields.length > 4 ? fields[4].trim() : "");
                c.setEmail1(fields.length > 5 ? fields[5].trim() : "");
                c.setEmail2(fields.length > 6 ? fields[6].trim() : "");
                c.setEmail3(fields.length > 7 ? fields[7].trim() : "");
                r.add(c);
                System.out.println("Contatti letti dal file: " + r);
                System.out.println("Contatto aggiunto: " + c.getNome() + " " + c.getCognome());
            }
        }catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
            throw e;  
        }
        return new Rubrica(r);
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
     
      try(PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter(filename)))){

        pw.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3");

        for(Contatto c : rubrica){

          if(c.getNome() != null){
            pw.print(c.getNome());
          }else{
            pw.print("");
          }
          pw.append(";");

          if(c.getCognome()!= null){
            pw.print(c.getCognome());
          }else{
               pw.print("");
          }
          pw.append(";");

          if(c.getNumero1()!= null){
            pw.print(c.getNumero1());
          }else{
              pw.print("");
          }
          pw.append(";");

          if(c.getNumero2()!= null){
              pw.print(c.getNumero2());
          }else{
              pw.print("");
          }
          pw.append(";");

          if(c.getNumero3()!= null){
              pw.print(c.getNumero3());
          }else{
              pw.print("");
          }
          pw.append(";");

          if(c.getEmail1()!= null){
              pw.print(c.getEmail1());
          }else{
              pw.print("");
          }
          pw.append(";");

          if(c.getEmail2()!= null){
              pw.print(c.getEmail2());
          }else{
              pw.print("");
          }
          pw.append(";");

          if(c.getEmail3()!= null){
              pw.print(c.getEmail3());
          }else{
              pw.print("");
          }
            pw.append("\n");
        }
      }
    }

}
