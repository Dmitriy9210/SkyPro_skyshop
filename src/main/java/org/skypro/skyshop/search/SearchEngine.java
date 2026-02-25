package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {

    public SearchEngine(int countArrays) {
        this.searchables = new Searchable[countArrays];
    }

    private final Searchable[] searchables;

    public Searchable[] search(String text) {
        Searchable[] newSearchables = new Searchable[5];
        int i = 0;
        for (Searchable s : searchables) {
            if (s != null && s.getSearchTerm().contains(text)) {
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

    public Searchable getSearchableSearch(String search) throws BestResultNotFound {
        int i = 0;
        Searchable searchable = null;

        for (Searchable s : searchables) {
            if (s == null) {
                continue;
            } else {
                String str = s.getSearchTerm();
                int count = 0;
                int index = 0;
                int indexOfSubstr = str.indexOf(search, index);

                while (indexOfSubstr != -1) {
                    count++;
                    index = indexOfSubstr + search.length();
                    indexOfSubstr = str.indexOf(search, index);
                }

                if (count > i) {
                    i = count;
                    searchable = s;
                }

            }
        }
        if (searchable == null){
            throw new BestResultNotFound(search);
        }else {
            return searchable;
        }
    }
}
