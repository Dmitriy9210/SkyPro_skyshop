package org.skypro.skyshop.search;

public class SearchEngine {

    public SearchEngine(int countArrays) {
        this.searchables = new Searchable[countArrays];
    }

    private final Searchable[] searchables;

    public Searchable[] search(String text) {
        Searchable[] newSearchables = new Searchable[5];
        int i = 0;
        for (Searchable s : searchables) {
            if (s!= null && s.searchTerm().contains(text)) {
                newSearchables[i] = s;
                i++;
            } else if (i > 6) {
                break;
            }
        }

        return newSearchables;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }

}
