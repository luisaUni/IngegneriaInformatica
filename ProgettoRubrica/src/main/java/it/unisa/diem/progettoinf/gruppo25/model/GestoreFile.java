/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;
import java.util.ArrayList;
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
    public static Rubrica importaCSV() throws IOException {
      Rubrica r = new Rubrica();
      try(BufferedReader br = new BufferedReader(new FileReader(file))){

            if(br.readLine() == null){ // controlla se il file sia vuoto (riga nulla)
                return r;
            }

            String line;
            while ((line = br.readLine()) != null) {
               String[] fields = line.split(";");
               String nome = fields.length > 0 ? fields[0] : null;
               String cognome = fields.length > 1 ? fields[1] : null;
               String numero1 = fields.length > 2 ? fields[2] : null;
               String numero2 = fields.length > 3 ? fields[3] : null;
               String numero3 = fields.length > 4 ? fields[4] : null;
               String email1 = fields.length > 5 ? fields[5] : null;
               String email2 = fields.length > 6 ? fields[6] : null;
               String email3 = fields.length > 7 ? fields[7] : null;

               Contatto c = new Contatto(nome, cognome, numero1, numero2, numero3, email1, email2, email3);
               r.aggiungiContatto(c);
           }

        }

        return r;

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
     * @throws IOException Se si verifica un errore durante l'accesso al file.
     */
    public static void scriviCSV(Contatto c) throws IOException {
      try(PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter(file)))){

        pw.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3");

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


    public static void esporta(String filename, ArrayList<Contatto> rubrica) throws IOException{
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
}
