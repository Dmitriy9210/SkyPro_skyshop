package org.skypro.skyshop.search;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.ComparatorArticle;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public Set<String> search(String text) {
        Set<Article> articles = new TreeSet<>(new ComparatorArticle());
        Set<String> result = new TreeSet<>();
        int i = 0;
        for (Searchable s : searchables) {
            if (s != null && s.getSearchTerm().contains(text)) {
                if (s instanceof Article) {
                    articles.add((Article) s);
                } else {
                    result.add(s.getSearchTerm());
                }
                i++;
            } else if (i > 6) {
                break;
            }
        }
        for (Article article : articles) {
            result.add(article.getSearchTerm());
        }
        return result;
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
