package com.virtual.SBN;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ValidateSBNTest {

    @Test
    public void checkAValid10DigitISBN() {
        ValidateSBN validator = new ValidateSBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkAValid13DigitISBN() {
        ValidateSBN validator = new ValidateSBN();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue("first value", result);
        result = validator.checkISBN("9781853267338");
        assertTrue("second value", result);
    }

    @Test
    public void TenDigitISBNNumbersEndingInAnXAreValid() {
        ValidateSBN validator = new ValidateSBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid10DigitISBN() {
        ValidateSBN validator = new ValidateSBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN() {
        ValidateSBN validator = new ValidateSBN();
        boolean result = validator.checkISBN("9781853267336");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNsAreNotAllowed() {
        ValidateSBN validator = new ValidateSBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNsAreNotAllowed() {
        ValidateSBN validator = new ValidateSBN();
        validator.checkISBN("helloworld");
    }

}
