package com.virtual.SBN;


import org.junit.Test;
import static org.junit.Assert.*;

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
    public void checkAnInvalidISBN() {
        ValidateSBN validateSBN = new ValidateSBN();
        boolean result = validateSBN.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected  = NumberFormatException.class)
    public  void nineDegit() {
        ValidateSBN validateSBN = new ValidateSBN();
        validateSBN.checkISBN("123456789");

    }
}