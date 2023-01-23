/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ua.edu.sumdu;

/*
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*; */

import ua.edu.sumdu.utils.Student;
import ua.edu.sumdu.customexceptions.EmailException;
import ua.edu.sumdu.customexceptions.AgeException;
import ua.edu.sumdu.utils.Utils;
import java.util.LinkedList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author polonskiy
 */
public class UtilsTest {
    static LinkedList<Student> studs;
    static LinkedList<Student> studs_exep;
    public UtilsTest() {
    }
    
    
    @BeforeAll
    public static void setUp() {
        studs = new LinkedList<Student>();
        studs.add(new Student("Name1", "Surname1", "100", "eee@test.com", "G1", "F1"));
        studs.add(new Student("Name2", "Surname2", "40", "eee2@test.com", "G2", "F2"));
        studs.add(new Student("Name3", "Surname3", "20", "eee2@test.org", "G3", "F3"));     
        studs.add(new Student("Name4", "Surname4", "20", "eee2@test.org", "G4", "F4"));          
        studs.add(new Student("Name5", "Surname5", "70", "eee@sumdu.edu.ua", "G5", "F5"));
        studs.add(new Student("Name6", "Surname6", "50", "eee@info.sumdu.edu.ua", "G5", "F5"));        
        
        studs_exep = new LinkedList<Student>();
        studs_exep.add(new Student("Exception", "Exception", "-10", "email", "test",  "test"));
    }
    
    /**
     * Test of calculatePopularDomain method, of class Utils.
     */
    @Test
    public void testCalculatePopularDomain() throws Exception {
        System.out.println("calculatePopularDomain");
        String expResult = "test.com; test.org";
        String result = Utils.calculatePopularDomain(studs);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateAverageAge method, of class Utils.
     */
    @Test
    public void testCalculateAverageAge() throws Exception {
        System.out.println("calculateAverageAge");
        double expResult = 50.0;
        double result = Utils.calculateAverageAge(studs);
        assertEquals(expResult, result, 0);      
    }
    
    /**
     * Test of calculatePopularDomain method, of class Utils with EmailException.
     * @throws ua.edu.sumdu.EmailException
     */    
    @Test
    public void whenEmailExceptionThrown_thenExpectationSatisfied() throws EmailException {
        
       
            Assertions.assertThrows(EmailException.class, () -> {
                Utils.calculatePopularDomain((LinkedList<Student>) studs_exep);
                });
        //studs.remove(3);
    }   

    /**
     * Test of testCalculateAverageAge method, of class Utils with EmailException.
     * @throws ua.edu.sumdu.AgeException
     */    
    @Test
    public void whenAgeExceptionThrown_thenExpectationSatisfied() throws AgeException {
        
       
            Assertions.assertThrows(AgeException.class, () -> {
                Utils.calculateAverageAge((LinkedList<Student>) studs_exep);
                });
        //studs.remove(3);
    }      
    
    /**
     * Test of calculateMaxAge method, of class Utils.
     */
    @Test
    public void testCalculateMaxAge() {
        System.out.println("calculateMaxAge");
        int expResult = 100;
        int result = Utils.calculateMaxAge(studs);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateMinAge method, of class Utils.
     */
    @Test
    public void testCalculateMinAge() {
        System.out.println("calculateMinAge");

        int expResult = 20;
        int result = Utils.calculateMinAge(studs);
        assertEquals(expResult, result);

    }

    /**
     * Test of patternMatches method, of class Utils.
     */
    @Test
    public void testPatternMatches() {
        System.out.println("patternMatches");
        String emailAddress = "eee2 test";
        boolean expResult = false;
        boolean result = Utils.patternMatches(emailAddress);
        assertEquals(expResult, result);
        
        emailAddress = "test@test.com";
        expResult = true;
        result = Utils.patternMatches(emailAddress);
        assertEquals(expResult, result);        

    }

    /**
     * Test of sumduPatternMatches method, of class Utils.
     */
    @Test
    public void testSumduPatternMatches() {
        System.out.println("sumduPatternMatches");
        String emailAddress = "eee2@test.org";
        boolean expResult = false;
        boolean result = Utils.sumduPatternMatches(emailAddress);
        assertEquals(expResult, result);
        
        emailAddress = "test@sumdu.edu.ua";
        expResult = true;
        result = Utils.sumduPatternMatches(emailAddress);
        assertEquals(expResult, result);   
        
        
        emailAddress = "test@info.sumdu.edu.ua";
        expResult = true;
        result = Utils.sumduPatternMatches(emailAddress);
        assertEquals(expResult, result);        

    }

    /**
     * Test of getEmailDomain method, of class Utils.
     */
    @Test
    public void testGetEmailDomain() {
        System.out.println("getEmailDomain");
        String someEmail = "eee2@test.org";
        String expResult = "test.org";
        String result = Utils.getEmailDomain(someEmail);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateSumduDomain method, of class Utils.
     */
    @Test
    public void testCalculateSumduDomain() throws Exception {
        System.out.println("calculateSumduDomain");
        int expResult = 2;
        int result = Utils.calculateSumduDomain(studs);
        assertEquals(expResult, result);
    }

    
}
