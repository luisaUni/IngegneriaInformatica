/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

/**
 *
 * @author luisacrivo
 */
public interface RubricaInterface {
    public void aggiungiContatto(Contatto c);
    public void eliminaContatto(Contatto c);
    public Contatto cercaContatto(String s);
    public void ordina(Rubrica e);
}
