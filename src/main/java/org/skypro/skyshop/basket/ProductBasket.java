package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final HashMap<String, List<Product>> products = new HashMap<>();

//    public void addProduct(Product product) {
//        List<Product> productsList = new LinkedList<>();
//        productsList.add(product);
//
//        products.put(product.getName(), productsList);
//        System.out.println("Добавлен " + product.getName());
//    }

    public void addProduct(Product product) {
        List<Product> productsList = new LinkedList<>();
        if (products.containsKey(product.getName())) {
            productsList = products.get(product.getName());
            productsList.add(product);
            products.put(product.getName(), productsList);
        } else {
            productsList.add(product);
            products.put(product.getName(), productsList);
        }
        System.out.println("Добавлен " + product.getName());
    }

    public int getProductPrice() {
        int sum = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    sum = sum + product.getPrice();
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

    public HashMap<String, List<Product>> deleteProduct(String name) {
        HashMap<String, List<Product>> newHashMap = new HashMap<>();

        if (products.containsKey(name)) {
            List<Product> productList = products.get(name);
            newHashMap.put(name, productList);
            products.remove(name);
            System.out.println("Удален продукт: " + name);
        }
        if (newHashMap.isEmpty()) {
            System.out.println("Список пуст");
        }
        return newHashMap;
    }
}