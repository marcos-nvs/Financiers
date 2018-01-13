/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.teste;

import br.com.ln.calculofinanceiro.CalculosFinanceiros;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TMDesen
 */
public class TesteCalculoFinanceiro {
    
    static CalculosFinanceiros financeiro;
    static Double parcela = 0d;
    
    public TesteCalculoFinanceiro() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        financeiro =  new CalculosFinanceiros();
        parcela = financeiro.calculoValorParcela(10000d, 2d, 12);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TesteFinanceiro(){
        assertEquals(parcela, financeiro.calculoValorParcela(10000d, 2d, 12), 0.00001);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
