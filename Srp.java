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
    ArrayList<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

     public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
      
       return total;
    }

    // 1. Violating SRP - Prints invoice (Should be in a separate class)
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }

     public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }


}
public class Srp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 509876));
        cart.addProduct(new Product("Mouse", 23));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}
