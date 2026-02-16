package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int price;

    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }


    public int getDiscount() {
        return discount;
    }

    @Override
    public int getPrice() {
        int newPrice = price - price * discount / 100;
        return newPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + ", скидка: " + getDiscount() + "%";

        //<имя продукта со скидкой>: <стоимость> (<скидка>%)
    }
}
