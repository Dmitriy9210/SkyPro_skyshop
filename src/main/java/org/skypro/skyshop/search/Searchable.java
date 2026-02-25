package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String getTypeContent();

    default String getStringRepresentation() {
        return "«имя " + searchTerm() + "-объекта — тип " + getTypeContent() + "-объекта»";
    }

    ;

}
