public class Burger {

    // Interface
    interface Burgers {
        void prepare();
    }

    // Concrete classes
    static class BasicBurger implements Burgers {
        @Override
        public void prepare() {
            System.out.println("Preparing Basic Burger");
        }
    }

    static class StandardBurger implements Burgers {
        @Override
        public void prepare() {
            System.out.println("Preparing Standard Burger");
        }
    }

    static class PremiumBurger implements Burgers {
        @Override
        public void prepare() {
            System.out.println("Preparing Premium Burger");
        }
    }

    // Factory class
    static class BurgerFactory {
        public Burgers createBurgers(String type) {
            if (type.equalsIgnoreCase("basic")) {
                return new BasicBurger();
            } else if (type.equalsIgnoreCase("standard")) {
                return new StandardBurger();
            } else if (type.equalsIgnoreCase("premium")) {
                return new PremiumBurger();
            } else {
                return null;
            }
        }
    }

    // Client Code
    public static void main(String[] args) {
        String type = "premium";
        BurgerFactory mBurgerFactory = new BurgerFactory();
        Burgers burger = mBurgerFactory.createBurgers(type);

        if (burger != null) {
            burger.prepare();  // Output: Preparing Premium Burger
        } else {
            System.out.println("Invalid Burger Type!");
        }
    }
}
