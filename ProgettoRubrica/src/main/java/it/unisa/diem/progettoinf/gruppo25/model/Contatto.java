/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

/**
 *
 * @author antoniofedullo
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

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero1() {
        return numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public String getNumero3() {
        return numero3;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumero1(String numero1) {
      if (numero1.equals(this.numero2) || numero1.equals(this.numero3)) {
        throw new IllegalArgumentException("Numero già esistente.");
    }
      this.numero1 = numero1;

    }

    public void setNumero2(String numero2) {
      if (numero2.equals(this.numero1) || numero2.equals(this.numero3)) {
        throw new IllegalArgumentException("Numero già esistente.");
  }
      this.numero2 = numero2;

    }

    public void setNumero3(String numero3) {
      if (numero3.equals(this.numero1) || numero3.equals(this.numero2)) {
        throw new IllegalArgumentException("Numero già esistente.");
   }
        this.numero3 = numero3;

    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public boolean isPreferito(){
      return preferito;
    }

    public void setPreferito(boolean preferito){
      this.preferito = preferito;
    }
}
