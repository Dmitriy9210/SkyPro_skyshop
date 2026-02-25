package org.skypro.skyshop.exception;

import java.io.FileNotFoundException;

public class BestResultNotFound extends FileNotFoundException {

    public BestResultNotFound(String s){
        super(s + " - не нашлось для такого запроса подходящей статьи");
    }
}
