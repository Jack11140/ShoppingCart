import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Product {
    private int key;
    private String name;
    private double price;

    public Product(int key, String name, double price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return key == product.key &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', key=" + key + ", price=" + price + '}';
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private HashMap<Integer, Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public void addProduct(Product product) {
        cartItems.put(product.getKey(), product);
        System.out.println("상품 추가: " + product.getName());
    }

    public void removeProduct(int key) {
        Product removedProduct = cartItems.remove(key);
        if (removedProduct != null) {
            System.out.println("상품 제거: " + removedProduct.getName());
        } else {
            System.out.println("장바구니에 해당 상품이 없습니다.");
        }
    }

    public void showItems() {
        System.out.println("장바구니에 담긴 상품 목록:");
        for (Product product : cartItems.values()) {
            System.out.println(product);
        }
    }
}

public class CartApp {
    public static void main(String[] args) {
        HashSet<Product> productSet = new HashSet<>();
        productSet.add(new Product(101, "노트북", 999.99));
        productSet.add(new Product(102, "스마트폰", 499.99));

        HashMap<Integer, Product> shoppingCart = new HashMap<>();

        for (Product product : productSet) {
            shoppingCart.put(product.getKey(), product);
        }

        ShoppingCart cart = new ShoppingCart();

        for (Product product : shoppingCart.values()) {
            cart.addProduct(product);
        }

        cart.showItems();

        cart.removeProduct(101);

        cart.showItems();
    }
}
