package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

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

    private long getSpecialCount(List<Product> product) {
        return product.stream()
                      .filter(Objects::nonNull)
                      .filter(Product::isSpecial)
                      .peek(System.out::println)
                      .count();
    }

    public void getAllProducts() {
        AtomicLong countEspecial = new AtomicLong();
        products.values().forEach(productList ->
                                          countEspecial.addAndGet(getSpecialCount(productList)));
        System.out.println("Специальных товаров: " + countEspecial.get());

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