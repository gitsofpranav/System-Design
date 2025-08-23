import java.util.*;
class Product{
    public String name;
    public double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

     public List<Product> getProducts() {
        return products;
    }

    public double calculatePrice(){
        double totalPrice = 0;
        for(Product p : products){
            totalPrice += p.price;
        }
        return totalPrice;
    }
}

    class ShoppingCartPrinter {
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculatePrice());
    }
}

class ShoppingCartStorage {
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}
public class SRPfollow {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("laptop", 50000));
        cart.addProduct(new Product("Samsaung", 34000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
