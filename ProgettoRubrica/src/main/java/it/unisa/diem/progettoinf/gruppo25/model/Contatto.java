/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

/**
 * @file Contatto.java
 * 
 * @brief Modello per rappresentare un contatto con numeri di telefono, email.
 * 
 * La classe `Contatto` rappresenta un contatto con informazioni personali come nome, cognome, numeri di telefono,
 * email e una flag per indicare se il contatto è preferito. Fornisce metodi getter e setter per gestire i dati.
 * Verifica che i numeri di telefono siano univoci tra loro.
 * 
 * @author Luisa Crivo, Francesca De Pascale, Antonio Manuel Fedullo
 */


public class Contatto {
    private String nome;
    private String cognome;
    private String numero1;
    private String numero2;
    private String numero3;
    private String email1;
    private String email2;
    private String email3;
    private boolean preferito;

    
    /**
     * @brief Costruttore della classe `Contatto`.
     * 
     * @param[in] nome Nome del contatto.
     * @param[in] cognome Cognome del contatto.
     * @param[in] numero1 Primo numero di telefono.
     * @param[in] numero2 Secondo numero di telefono.
     * @param[in] numero3 Terzo numero di telefono.
     * @param[in] email1 Prima email del contatto.
     * @param[in] email2 Seconda email del contatto.
     * @param[in] email3 Terza email del contatto.
     */
    public Contatto(String nome, String cognome, String numero1, String numero2, String numero3, String email1, String email2, String email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
    }

    /** 
     * @brief Restituisce il nome del contatto. 
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Restituisce il cognome del contatto. 
     *  @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

     /** 
      * @brief Restituisce il primo numero di telefono del contatto. 
      * @return Primo numero di telefono.
      */
    public String getNumero1() {
        return numero1;
    }

    /** 
     * @brief Restituisce il secondo numero di telefono del contatto.
     * @return Secondo numero di telefono.
     */
    public String getNumero2() {
        return numero2;
    }

     /** 
      * @brief Restituisce il terzo numero di telefono del contatto. 
      * @return Terzo numero di telefono.
      */
    public String getNumero3() {
        return numero3;
    }

    /**
     * @brief Restituisce la prima email del contatto. 
     * @return Prima email del contatto.
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * @brief Restituisce la seconda email del contatto. 
     * @return Seconda email del contatto.
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * @brief Restituisce la terza email del contatto. 
     * @return Terza email del contatto.
     */
    public String getEmail3() {
        return email3;
    }

    /** @brief Imposta il nome del contatto.
     *  @param[in] nome Nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @brief Imposta il cognome del contatto.
     *  @param[in] cognome Cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /** 
     * @brief Imposta il primo numero di telefono del contatto.
     * @param[in] numero1 Primo numero di telefono.
     */
    public void setNumero1(String numero1) {
      if (numero1.equals(this.numero2) || numero1.equals(this.numero3)) {
        throw new IllegalArgumentException("Numero già esistente.");
    }
      this.numero1 = numero1;

    }

    /** 
     * @brief Imposta il secondo numero di telefono del contatto.
     * @param[in] numero2 Secondo numero di telefono.
     */
    public void setNumero2(String numero2) {
      if (numero2.equals(this.numero1) || numero2.equals(this.numero3)) {
        throw new IllegalArgumentException("Numero già esistente.");
  }
      this.numero2 = numero2;

    }

    /** 
     * @brief Imposta il terzo numero di telefono del contatto.
     * @param[in] numero3 Terzo numero di telefono.
     */
    public void setNumero3(String numero3) {
      if (numero3.equals(this.numero1) || numero3.equals(this.numero2)) {
        throw new IllegalArgumentException("Numero già esistente.");
   }
        this.numero3 = numero3;

    }

    /** 
     * @brief Imposta la prima email del contatto.
     * @param[in] email1 Prima email del contatto.
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    /** 
     * @brief Imposta la seconda email del contatto.
     * @param[in] email2 Seconda email del contatto.
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /** 
     * @brief Imposta la terza email del contatto.
     * @param[in] email3 Terza email del contatto.
     */
    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    /** 
     * @brief Restituisce lo stato di preferenza del contatto.
     * @return `true` se il contatto è preferito, `false` altrimenti.
     */
    public boolean isPreferito(){
      return preferito;
    }

    /** 
     * @brief Imposta lo stato di preferenza del contatto.
     * @param[in] preferito `true` se il contatto è preferito, `false` altrimenti.
     */
    public void setPreferito(boolean preferito){
      this.preferito = preferito;
    }
}
