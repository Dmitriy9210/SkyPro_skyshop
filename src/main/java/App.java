import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class App {

    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Молоко1", 50);
        Product product2 = new DiscountedProduct("Молоко2", 100, 20);
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

        System.out.println(productBasket2.getProductPrice());
        System.out.println(productBasket2.isProductInBasket("Сметана"));

        System.out.println("_______________________________");
        System.out.println("Interface");

        Article article1 = new Article("Огурцы111111", "Огурцы надо есть сразу из банки");
        Article article2 = new Article("Помидоры", "Выбирай самые красные");
        Article article3 = new Article("Молоко2222222222", "Всегдя кипяти");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println(product1.getTypeContent());
        System.out.println(product2.getTypeContent());
        System.out.println(product3.getTypeContent());
        System.out.println(product4.getTypeContent());
        System.out.println(product5.getTypeContent());
        System.out.println(article1.getTypeContent());
        System.out.println(article2.getTypeContent());
        System.out.println(article2.getTypeContent());

        System.out.println(product1.getStringRepresentation());
        System.out.println(product2.getStringRepresentation());
        System.out.println(product3.getStringRepresentation());
        System.out.println(product4.getStringRepresentation());
        System.out.println(product5.getStringRepresentation());
        System.out.println(article1.getStringRepresentation());
        System.out.println(article2.getStringRepresentation());
        System.out.println(article2.getStringRepresentation());
        System.out.println(searchEngine.search("о"));

        System.out.println("_______________________________");
        System.out.println("Exception");
        try {
            Product product7 = new SimpleProduct("Молоко", 0);
            Product product8 = new DiscountedProduct("", 111, 1000);
            Product product9 = new FixPriceProduct("   ");
            Product product10 = new SimpleProduct(null, 33);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("_______________________________");
        try {
            System.out.println(searchEngine.getSearchableSearch("о"));
            System.out.println(searchEngine.getSearchableSearch("оaa"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("_______________________________");
        System.out.println("List");
        Product product11 = new DiscountedProduct("Молоко", 100, 20);
        Product product12 = new FixPriceProduct("Молоко");
        productBasket.addProduct(product11);
        productBasket.addProduct(product12);
        System.out.println(productBasket.removeProduct("Молоко"));
        System.out.println(productBasket.removeProduct("Молоко1"));
        System.out.println("_______________________________");
        productBasket.getAllProducts();
    }
}
