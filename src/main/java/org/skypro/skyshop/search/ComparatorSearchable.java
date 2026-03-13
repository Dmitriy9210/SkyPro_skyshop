package org.skypro.skyshop.search;

import java.util.Comparator;

public class ComparatorSearchable implements Comparator<Searchable> {

    @Override
    public int compare(Searchable a1, Searchable a2) {
        int result = Integer.compare(a2.getSearchTerm().length(), a1.getSearchTerm().length());
        if (result == 0) {
            return a1.getSearchTerm().compareTo(a2.getSearchTerm());
        }
        return result;
    }
}