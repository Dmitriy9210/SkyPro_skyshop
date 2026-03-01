package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Добавлен " + product.getName());
    }

    public int getProductPrice() {
        int sum = 0;
        for (Product product : this.products) {
            if (product != null) {
                sum = sum + product.getPrice();
            }
        }
        return sum;
    }

    public void getAllProducts() {
        int j = 0;
        int countEspecial = 0;
        for (Product product : this.products) {
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
        int sum = getProductPrice();
        if (sum > 0) {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + countEspecial);
        }
    }

    public boolean isProductInBasket(String productStr) {
        for (Product product : this.products) {
            if (product != null && product.getName().equals(productStr)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> deleteProduct(String name) {
        List<Product> newList = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().contains(name)) {
                newList.add(p);
                iterator.remove();
                System.out.println("Удален продукт: " + name);
            }
        } if (newList.isEmpty()) {
            System.out.println("Список пуст");
        }

        return newList;
    }
}