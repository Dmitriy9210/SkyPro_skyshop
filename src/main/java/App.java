import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Молоко", 50);
        Product product2 = new DiscountedProduct("Сметана", 100, 20);
        Product product3 = new FixPriceProduct("Лук");
        Product product4 = new SimpleProduct("Апельсин", 33);
        Product product5 = new DiscountedProduct("Арбуз", 120, 10);
        Product product6 = new FixPriceProduct("Молоток");

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);
        System.out.println("__________________");
        productBasket.getAllProducts();
        System.out.println("__________________");

        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(product1);
        productBasket2.addProduct(product2);
        productBasket2.addProduct(product3);
        System.out.println("__________________");
        productBasket2.getAllProducts();
        System.out.println("__________________");

        System.out.println("productBasket.getProductPrice() = " + productBasket2.getProductPrice());

        System.out.println(productBasket2.isProductInBasket("Сметана"));
        System.out.println(productBasket2.isProductInBasket("Чай"));

        productBasket2.clearBasket();
        productBasket2.getAllProducts();

        System.out.println( productBasket2.getProductPrice());
        System.out.println(productBasket2.isProductInBasket("Сметана"));
    }
}
