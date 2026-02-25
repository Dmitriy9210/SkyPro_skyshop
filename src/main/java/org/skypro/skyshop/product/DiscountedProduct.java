package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int price;

    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        if (price > 0 && (discount >= 0 && discount <= 100)) {
            this.price = price;
            this.discount = discount;
        } else {
            throw new IllegalArgumentException(
                    "Неверная цена DiscountedProduct.price = " + price + " или неверный DiscountedProduct.discount = " + discount);
        }
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
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }
}
