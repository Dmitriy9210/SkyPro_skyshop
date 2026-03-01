package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String s) {
        super(s + " - не нашлось для такого запроса подходящей статьи");
    }
}
