package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final static int FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена: " + getPrice();
    }

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }
}
