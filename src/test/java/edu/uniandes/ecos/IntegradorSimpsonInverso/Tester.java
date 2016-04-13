package edu.uniandes.ecos.IntegradorSimpsonInverso;

import edu.uniandes.ecos.IntegradorSimpsonInverso.modelo.BuscadorX;
import edu.uniandes.ecos.IntegradorSimpsonInverso.modelo.IntegradorSimpson;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @name Tester
 * @author Juan
 * @version 1.0
 * @date 07/04/2016
 * @description clase encargada de ejecutar los test de prueba a traves de JUnit.
 */
public class Tester extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Tester( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Tester.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 1
     */
    @org.junit.Test
    public void test1(){
        
       try {
            BuscadorX buscadorX = new BuscadorX();
            double xActual = buscadorX.buscarX(0.20, 1.0, 6, 10);
            xActual = IntegradorSimpson.redondear(xActual, 5);
            
            assertTrue(0.55338 <= xActual && xActual <= 0.55350);
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 2
     */
    @org.junit.Test
    public void test2() {

        try {
            BuscadorX buscadorX = new BuscadorX();
            double xActual = buscadorX.buscarX(0.45, 1.0, 15, 10);

            assertEquals(1.75305, IntegradorSimpson.redondear(xActual, 5));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 3
     */
    @org.junit.Test
    public void test3(){
        
       try {
            BuscadorX buscadorX = new BuscadorX();
            double xActual = buscadorX.buscarX(0.495, 1.0, 4, 10);
            xActual = IntegradorSimpson.redondear(xActual, 5);
            
            assertTrue(4.6010 <= xActual && xActual <= 4.60409);
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



