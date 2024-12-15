/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luisacrivo
 */
public class ProgettoTestIntegrativo {
    
         
    private GestoreFile gestoreFile;
    private Rubrica rubrica;

    @BeforeEach
    void setUp() {
        // Inizializza le componenti principali del progetto
        gestoreFile = new GestoreFile();
        rubrica = new Rubrica(new ArrayList<>());
    }

    @Test
    void testImportaModificaEsporta() throws IOException {
        // Crea un file temporaneo di input CSV
        File inputFile = File.createTempFile("rubrica", ".csv");
        File outputFile = File.createTempFile("rubrica_output", ".csv");

        // Scrive dati di test nel file di input
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            writer.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3;");
            writer.println("Mario;Rossi;123456789;;123;;;");
            writer.println("Luca;Bianchi;987654321;654321;;email1@example.com;;email3@example.com;");
        }

        // 1. Importa i dati dal file
        rubrica = gestoreFile.importa(inputFile.getAbsolutePath());
        assertEquals(2, rubrica.getContatti().size(), "La rubrica deve contenere 2 contatti dopo l'importazione.");

        // 2. Modifica i dati in memoria
        Contatto nuovoContatto = new Contatto("Giulia", "Verdi", "111222333", "", "", "", "", "", true);
        rubrica.aggiungiContatto(nuovoContatto);
        assertEquals(3, rubrica.getContatti().size(), "La rubrica deve contenere 3 contatti dopo l'aggiunta.");

        // 3. Esporta i dati in un nuovo file
        gestoreFile.esporta(outputFile.getAbsolutePath(), (ArrayList<Contatto>) rubrica.getContatti());

        // 4. Verifica che il file esportato contenga i dati attesi
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String header = reader.readLine();
            assertEquals("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3;", header, "L'header del file esportato non è corretto.");

            String primaRiga = reader.readLine();
            assertEquals("Mario;Rossi;123456789;;123;;;;", primaRiga, "Il primo contatto non è corretto.");

            String secondaRiga = reader.readLine();
            assertEquals("Luca;Bianchi;987654321;654321;;email1@example.com;;email3@example.com;", secondaRiga, "Il secondo contatto non è corretto.");

            String terzaRiga = reader.readLine();
            assertEquals("Giulia;Verdi;111222333;;;;;;", terzaRiga, "Il terzo contatto non è corretto.");
        }
    }
}
