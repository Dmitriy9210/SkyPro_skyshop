package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public Set<Searchable> search(String text) {
        return searchables.stream()
                          .filter(s -> s != null && s.getSearchTerm().contains(text))
                          .limit(6)
                          .collect(Collectors.toCollection(() -> new TreeSet<>(new ComparatorSearchable())));
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
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
        if (searchable == null) {
            throw new BestResultNotFound(search);
        } else {
            return searchable;
        }
    }
}
