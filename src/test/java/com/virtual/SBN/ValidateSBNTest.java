package com.virtual.SBN;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ValidateSBNTest {

    @Test
    public void checkISBN() {
        ValidateSBN validateSBN = new ValidateSBN();
        boolean result = validateSBN.checkISBN("0140449116");
        assertTrue("First value", result);
        result = validateSBN.checkISBN("0140177396");
        assertTrue("Second value", result);
    }
    @Test
    public void ISBNNumbersEndingAnXAreValid() {
        ValidateSBN validateSBN = new ValidateSBN();
        boolean result = validateSBN.checkISBN("012000030X");
        assertTrue(result);
    }
    @Test
    public void checkValid13DigitsISBN() {
        ValidateSBN validateSBN = new ValidateSBN();
        boolean result = validateSBN.checkISBN("9781853260087");
        assertTrue(result);
    }
    @Test
    public void checkAnInval10idISBN() {
        ValidateSBN validateSBN = new ValidateSBN();
        boolean result = validateSBN.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected  = NumberFormatException.class)
    public  void nineDegit() {
        ValidateSBN validateSBN = new ValidateSBN();
        validateSBN.checkISBN("123456789");

    }
    @Test(expected  = NumberFormatException.class)
    public void notNumbericISBNAreNotAllowed() {
        ValidateSBN validateSBN = new ValidateSBN();
        validateSBN.checkISBN("helloworld");
    }
}