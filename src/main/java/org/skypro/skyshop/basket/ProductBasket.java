package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Добавлен " + product.getName());
                return;
            } else if (products[products.length - 1] != null) {
                System.out.println("Невозможно добавить продукт");
                return;
            }
        }
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
        for (Product product : this.products) {
            if (product != null) {
                System.out.println(product);
                j++;
            } else if (j == 0) {
                System.out.println("в корзине пусто");
                break;
            }
        }
        int sum = getProductPrice();
        if (sum > 0) {
            System.out.println(sum);
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
        for (int j = 0; j < products.length; j++) {
            products[j] = null;
        }
    }
}