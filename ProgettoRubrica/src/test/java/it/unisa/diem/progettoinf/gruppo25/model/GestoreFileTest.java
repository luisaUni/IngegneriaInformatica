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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author francescadepascale
 */
public class GestoreFileTest {
    private static final String TEST_FILE = "testRubrica.csv";
    private GestoreFile gestoreFile;
    
    public GestoreFileTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup della classe di test...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tear down della classe di test...");
    }
    
    @BeforeEach
    public void setUp() {
        gestoreFile = new GestoreFile();
    }
    
    @AfterEach
    public void tearDown() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

     /**
     * Test del metodo importa della classe GestoreFile.
     */
    @Test
    public void testImporta_Success() throws Exception {
        System.out.println("Testing importa with a valid file");
        // Crea un file CSV di test
        try (PrintWriter pw = new PrintWriter(new FileWriter(TEST_FILE))) {
            pw.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3");
            pw.println("Mario;Rossi;123456789;;12345;mario.rossi@example.com;;;");
            pw.println("Luigi;Verdi;987654321;;;luigi.verdi@example.com;;;");
        }

        Rubrica rubrica = gestoreFile.importa(TEST_FILE);

        assertNotNull(rubrica, "La rubrica importata non deve essere null");
        assertEquals(2, rubrica.getContatti().size(), "La rubrica deve contenere 2 contatti");

        Contatto contatto1 = rubrica.getContatti().get(0);
        assertEquals("Mario", contatto1.getNome());
        assertEquals("Rossi", contatto1.getCognome());
        assertEquals("123456789", contatto1.getNumero1());
        assertEquals("12345", contatto1.getNumero3());
        assertEquals("mario.rossi@example.com", contatto1.getEmail1());

        Contatto contatto2 = rubrica.getContatti().get(1);
        assertEquals("Luigi", contatto2.getNome());
        assertEquals("Verdi", contatto2.getCognome());
        assertEquals("987654321", contatto2.getNumero1());
        assertEquals("luigi.verdi@example.com", contatto2.getEmail1());
    }
    
    @Test
    public void testImporta_FileVuoto() throws Exception {
        System.out.println("Testing importa with an empty file");
        try (PrintWriter pw = new PrintWriter(new FileWriter(TEST_FILE))) {
            pw.println("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3");
        }

        Rubrica rubrica = gestoreFile.importa(TEST_FILE);
        assertNotNull(rubrica, "La rubrica importata non deve essere null");
        assertTrue(rubrica.getContatti().isEmpty(), "La rubrica deve essere vuota");
    }

    
    @Test
    public void testImporta_FileNonEsistente() {
        System.out.println("Testing importa with a non-existent file");
        String invalidFilename = "nonexistent.csv";

        assertThrows(IOException.class, () -> {
            gestoreFile.importa(invalidFilename);
        }, "L'importazione di un file inesistente deve generare IOException");
    }
    
    /**
     * Test of esporta method, of class GestoreFile.
     */
    @Test
    public void testEsporta_Success() throws IOException {
       System.out.println("testEsporta_Success");

        String filename = "test_export.csv";
        ArrayList<Contatto> rubrica = new ArrayList<>();

        // Creazione di un contatto di test
        Contatto c1 = new Contatto();
        c1.setNome("Mario");
        c1.setCognome("Rossi");
        c1.setNumero1("123456789");
        c1.setNumero2(null);
        c1.setNumero3("12345");
        c1.setEmail1("mario.rossi@example.com");
        c1.setEmail2(null);
        c1.setEmail3(null);
        rubrica.add(c1);

        // Esegui il metodo
        GestoreFile.esporta(filename, rubrica);

        // Leggi il contenuto generato per verificarlo
        List<String> lines = Files.readAllLines(Paths.get(filename));

        // Verifica delle righe generate
        assertEquals("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3;", lines.get(0));
        assertEquals("Mario;Rossi;123456789;;12345;mario.rossi@example.com;;;", lines.get(1));
}

    @Test
    public void testEsporta_RubricaVuota() throws Exception {
        System.out.println("Testing esporta with an empty contact list");

        ArrayList<Contatto> contatti = new ArrayList<>();

        GestoreFile.esporta(TEST_FILE, contatti);

        // Verifica che il file contenga solo l'intestazione
        try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
            String header = br.readLine();
            assertEquals("NOME;COGNOME;NUMERO1;NUMERO2;NUMERO3;E-MAIL1;E-MAIL2;E-MAIL3", header);
            assertNull(br.readLine(), "Il file deve contenere solo l'intestazione");
        }
    }

    @Test
    public void testEsporta_FileNonScrivibile() {
        System.out.println("Testing esporta with a non-writable file");

        File readOnlyFile = new File(TEST_FILE);
        try {
            // Crea un file e rendilo non scrivibile
            readOnlyFile.createNewFile();
            readOnlyFile.setReadOnly();

            ArrayList<Contatto> contatti = new ArrayList<>();
            contatti.add(new Contatto("Mario", "Rossi", "123456789", null, null, "mario.rossi@example.com", null, null, false));

            assertThrows(IOException.class, () -> {
                GestoreFile.esporta(TEST_FILE, contatti);
            }, "L'esportazione su un file non scrivibile deve generare IOException");

        } catch (IOException e) {
            fail("Errore nella creazione del file di test: " + e.getMessage());
        } finally {
            // Ripristina i permessi del file per consentirne l'eliminazione
            readOnlyFile.setWritable(true);
        }
    }

    
    
}
