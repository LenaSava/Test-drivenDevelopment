package com.virtual.SBN;

public class ValidateSBN {

    public static final int LongISBN = 13;
    public static final int ShortISBN = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == LongISBN) {
            return IsThisValid13(isbn);

        } else {
            if (isbn.length() != ShortISBN) throw new NumberFormatException("ISBN number must be 10 digit");

            return IsThisValid10(isbn);
        }

    }

    private boolean IsThisValid10(String isbn) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                }
                else {
                    throw new NumberFormatException("ISBN numbers can only include digit");
                }
            }
            else {
                total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
            }
        }

        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean IsThisValid13(String isbn) {
        int total = 0;
        for (int i = 0; i < 13; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        if (total % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}