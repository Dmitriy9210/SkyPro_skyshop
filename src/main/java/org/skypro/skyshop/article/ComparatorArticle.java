package org.skypro.skyshop.article;

import java.util.Comparator;

public class ComparatorArticle implements Comparator<Article> {

    @Override
    public int compare(Article a1, Article a2) {
        int result = Integer.compare(a2.getTitle().length(), a1.getTitle().length());
        if (result == 0) {
            return a1.getTitle().compareTo(a2.getTitle());
        }
        return result;
    }
}