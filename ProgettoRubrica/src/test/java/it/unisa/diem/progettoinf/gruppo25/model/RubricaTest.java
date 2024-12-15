/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.progettoinf.gruppo25.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
public class RubricaTest {
    
       
    private Rubrica rubrica;
    private Contatto contatto1;
    private Contatto contatto2;
    
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup class...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tear down class...");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Setup test...");
        // Inizializzazione di ogni test con una nuova rubrica
        rubrica = new Rubrica();
        
        // Aggiungiamo alcuni contatti di esempio
        rubrica.aggiungiContatto(new Contatto("Luisa", "Crivo", "1234567890", "", "", "luisa@example.com", "", "", true));
        rubrica.aggiungiContatto(new Contatto("Francesca", "De Pascale", "0987654321", "", "", "francesca@example.com", "", "", true));
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Tear down test...");
        // Operazioni post-test, come la rimozione di contatti o il reset della rubrica
        rubrica = null;  
    }
    
    /**
     * Test per verificare l'aggiunta di contatti alla rubrica.
     */
    
    @Test
    public void testAggiungiContatto() {
        Contatto contatto = new Contatto("Mario", "Rossi", "1234567890", "", "", "mario.rossi@example.com", "", "", true);
        rubrica.aggiungiContatto(contatto);

        // Verifica che il contatto sia stato aggiunto
        assertTrue(rubrica.getContatti().contains(contatto));
    }

    /**
     * Test di eliminazione di un contatto
     */
    @Test
    public void testEliminaContatto() {
        Rubrica rubrica = new Rubrica();
    Contatto contatto = new Contatto("Francesca", "De Pascale", "0987654321", "", "", "francesca@example.com", "", "",true);
        rubrica.aggiungiContatto(contatto);
        rubrica.eliminaContatto(contatto);
        
        // Verifica che il contatto sia stato eliminato
        assertFalse(rubrica.getContatti().contains(contatto));
    }

    /**
     * Test di ricerca di un contatto
     */
    @Test
    public void testCercaContatto() {
    Rubrica rubrica = new Rubrica();

        Contatto contatto1 = new Contatto("Luisa", "Crivo", "1234567890", "", "", "luisa@example.com", "", "", true);
        Contatto contatto2 = new Contatto("Francesca", "De Pascale", "0987654321", "", "", "francesca@example.com", "", "", true);
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        // Ricerca per nome
        List<Contatto> risultati = rubrica.cercaContatto("Luisa");
        assertEquals(1, risultati.size());
        assertTrue(risultati.contains(contatto1));
    }

    /**
     * Test di ordinamento dei contatti
     */
    @Test
    public void testOrdinaContatti() {
        Contatto contatto1 = new Contatto("Mario", "Rossi", "12345", "", "", "", "","", true);
        Contatto contatto2 = new Contatto("Lucia", "Bianchi", "67890",  "", "", "", "","", true);
        Contatto contatto3 = new Contatto("Mario", "Verdi", "54321",  "", "", "", "","", true);

        List<Contatto> contatti = new ArrayList<>();
        contatti.add(contatto1);
        contatti.add(contatto2);
        contatti.add(contatto3);

        // Ordinamento
        contatti.sort((c1, c2) -> {
            int nomeCmp = c1.getNome().compareTo(c2.getNome());
            if (nomeCmp != 0) {
                return nomeCmp;
            }
            return c1.getCognome().compareTo(c2.getCognome());
        });

        // Verifica che i contatti siano ordinati per nome e cognome
        assertEquals(contatto2, contatti.get(0));  // Lucia Bianchi
        assertEquals(contatto1, contatti.get(1));  // Mario Rossi
        assertEquals(contatto3, contatti.get(2));  // Mario Verdi
    }
    
    
    
}
