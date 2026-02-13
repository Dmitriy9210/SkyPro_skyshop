import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {
        Product product1 = new Product("Молоко", 50);
        Product product2 = new Product("Сметана", 100);
        Product product3 = new Product("Лук", 20);
        Product product4 = new Product("Апельсин", 33);
        Product product5 = new Product("Арбуз", 120);
        Product product6 = new Product("Молоток", 300);

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);

        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(product1);
        productBasket2.addProduct(product2);
        productBasket2.addProduct(product3);
        productBasket2.getAllProducts();

        System.out.println("productBasket.getProductPrice() = " + productBasket2.getProductPrice());

        System.out.println(productBasket2.isProductInBasket("Сметана"));
        System.out.println(productBasket2.isProductInBasket("Чай"));

        productBasket2.clearBasket();
        productBasket2.getAllProducts();

        System.out.println( productBasket2.getProductPrice());
        System.out.println(productBasket2.isProductInBasket("Сметана"));

    }
}
