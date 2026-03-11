package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), key -> new LinkedList<>())
                .add(product);
        System.out.println("Добавлен " + product.getName());
    }

    public int getProductPrice() {
        int sum = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    public void getAllProducts() {
        int j = 0;
        int countEspecial = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    if (product.isSpecial()) {
                        countEspecial++;
                    }
                    System.out.println(product);
                    j++;
                } else if (j == 0) {
                    System.out.println("в корзине пусто");
                    break;
                }
            }
        }
        int sum = getProductPrice();
        if (sum > 0) {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + countEspecial);
        }
    }

    public boolean isProductInBasket(String productStr) {
        return products.get(productStr) != null;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> newList = new LinkedList<>();
        if (products.containsKey(name)) {
            newList.addAll(products.get(name));
            products.remove(name);
            System.out.println("Удален продукт: " + name);
        }
        if (newList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return newList;
    }
}