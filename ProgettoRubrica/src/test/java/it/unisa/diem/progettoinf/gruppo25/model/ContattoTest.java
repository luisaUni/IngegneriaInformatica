/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

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
public class ContattoTest {
    private Contatto contatto;
    
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup class.");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tear down della classe di test...");
    }
    
    @BeforeEach
    public void setUp() {
        contatto = new Contatto( "Mario", "Rossi", 
            "+393331234567", "+393334567890", "+393337890123", 
            "mario.rossi@example.com", "rossi.mario@example.org", "mario.r@example.net", false);

    }
    
    @AfterEach
    public void tearDown() {
        contatto = null;
    }

    /**
     * Test per il costruttore con parametri e i metodi getter.
     */
    @Test
    public void testCostruttoreEGetter() {
        // Verifica dei valori
        assertEquals("Mario", contatto.getNome(), "Il nome dovrebbe essere Mario");
        assertEquals("Rossi", contatto.getCognome(), "Il cognome dovrebbe essere Rossi");
        assertEquals("+393331234567", contatto.getNumero1(), "Il primo numero dovrebbe essere corretto");
        assertEquals("+393334567890", contatto.getNumero2(), "Il secondo numero dovrebbe essere corretto");
        assertEquals("+393337890123", contatto.getNumero3(), "Il terzo numero dovrebbe essere corretto");
        assertEquals("mario.rossi@example.com", contatto.getEmail1(), "La prima email dovrebbe essere corretta");
        assertEquals("rossi.mario@example.org", contatto.getEmail2(), "La seconda email dovrebbe essere corretta");
        assertEquals("mario.r@example.net", contatto.getEmail3(), "La terza email dovrebbe essere corretta");
    }

    /**
     * Test per i metodi setter e la modifica dei valori.
     */
    @Test
    public void testSetter() {
        // Modifica dei valori tramite setter
        contatto.setNome("Anna");
        contatto.setCognome("Bianchi");
        contatto.setNumero1("+393339876543");
        contatto.setNumero2("+393334567890");
        contatto.setNumero3("+393332345678");
        contatto.setEmail1("anna.bianchi@example.com");
        contatto.setEmail2("bianchi.anna@example.org");
        contatto.setEmail3("anna.b@example.net");
        contatto.setPreferito(true);

        // Verifica dei valori modificati
        assertEquals("Anna", contatto.getNome(), "Il nome dovrebbe essere Anna");
        assertEquals("Bianchi", contatto.getCognome(), "Il cognome dovrebbe essere Bianchi");
        assertEquals("+393339876543", contatto.getNumero1(), "Il primo numero dovrebbe essere corretto");
        assertEquals("+393334567890", contatto.getNumero2(), "Il secondo numero dovrebbe essere corretto");
        assertEquals("+393332345678", contatto.getNumero3(), "Il terzo numero dovrebbe essere corretto");
        assertEquals("anna.bianchi@example.com", contatto.getEmail1(), "La prima email dovrebbe essere corretta");
        assertEquals("bianchi.anna@example.org", contatto.getEmail2(), "La seconda email dovrebbe essere corretta");
        assertEquals("anna.b@example.net", contatto.getEmail3(), "La terza email dovrebbe essere corretta");
        assertTrue(contatto.isPreferito(), "Il contatto dovrebbe essere preferito");
    }

    /**
     * Test per verificare i valori di default.
     */
    @Test
    public void testValoriDefault() {
        System.out.println("Esecuzione testValoriDefault");

        // Creazione di un oggetto `Contatto` vuoto
        Contatto contattoDefault = new Contatto();

        // Verifica dei valori di default
        assertNull(contattoDefault.getNome());
        assertNull(contattoDefault.getCognome());
        assertNull(contattoDefault.getNumero1());
        assertNull(contattoDefault.getNumero2());
        assertNull(contattoDefault.getNumero3());
        assertNull(contattoDefault.getEmail1());
        assertNull(contattoDefault.getEmail2());
        assertNull(contattoDefault.getEmail3());
        assertFalse(contattoDefault.isPreferito());
    }

    /**
     * Test per verificare l'uguaglianza e il confronto alfabetico.
     */
    @Test
    public void testUguaglianzaEConfronto() {
        Contatto contatto1 = new Contatto("Giulia", "Neri", "", "", "", "", "", "", false);
        Contatto contatto2 = new Contatto("Giulia", "Neri", "", "", "", "", "", "", false);
        Contatto contatto3 = new Contatto("Luca", "Verdi", "", "", "", "", "", "", false);

        // Test per equals
        assertEquals(contatto1, contatto2, "I contatti con lo stesso nome e cognome dovrebbero essere uguali");
        assertNotEquals(contatto1, contatto3, "I contatti con nomi diversi non dovrebbero essere uguali");

        // Test per compareTo
        assertEquals(0, contatto1.compareTo(contatto2), "I contatti uguali dovrebbero restituire 0 nel confronto");
        assertTrue(contatto1.compareTo(contatto3) < 0, "Il confronto alfabetico dovrebbe restituire un valore negativo");
        assertTrue(contatto3.compareTo(contatto1) > 0, "Il confronto alfabetico inverso dovrebbe restituire un valore positivo");
    }

    
}
