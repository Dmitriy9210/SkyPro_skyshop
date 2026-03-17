package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {


        products.computeIfAbsent(product.getName(), key -> new LinkedList<>())
                .add(product);
        System.out.println("Добавлен " + product.getName());
    }

    public int getProductPrice() {
        return products.values().stream().flatMap(Collection::stream)
                       .mapToInt(Product::getPrice).sum();
    }

    private void getSpecialCount() {
        long count = products.values().stream()
                             .flatMap(Collection::stream)
                             .filter(Objects::nonNull)
                             .filter(Product::isSpecial)
                             .count();
        System.out.println("Специальных товаров: " + count);
    }

    public void getAllProducts() {
        getSpecialCount();
        products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .forEach(System.out::println);

        int sum = getProductPrice();
        if (sum > 0) {
            System.out.println("Итого: " + sum);
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