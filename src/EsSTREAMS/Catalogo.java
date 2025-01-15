package EsSTREAMS;



import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Catalogo {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product(1, "Java Programming", "Books", 150.0),
                new Product(2, "Harry Potter", "Books", 50.0),
                new Product(3, "Baby Monitor", "Baby", 120.0),
                new Product(4, "Boys T-shirt", "Boys", 40.0),
                new Product(5, "Boys Jeans", "Boys", 80.0)
        );

        Customer customer1 = new Customer(1, "Alice", 2);
        Customer customer2 = new Customer(2, "Bob", 1);

        List<Order> orders = Arrays.asList(
                new Order(1, "completed", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15),
                        Arrays.asList(products.get(0), products.get(2)), customer1),
                new Order(2, "pending", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 20),
                        Arrays.asList(products.get(3), products.get(4)), customer2)
        );

        Catalogo example = new Catalogo();

        // Esercizio 1: Prodotti categoria "Books" con prezzo > 100
        List<Product> booksAbove100 = example.getBooksWithPriceGreaterThan100(products);
        System.out.println("Esercizio 1: " + booksAbove100);

        // Esercizio 2: Ordini con prodotti categoria "Baby"
        List<Order> ordersWithBabyProducts = example.getOrdersWithBabyProducts(orders);
        System.out.println("Esercizio 2: " + ordersWithBabyProducts);

        // Esercizio 3: Prodotti categoria "Boys" con sconto del 10%
        List<Product> boysDiscounted = example.getBoysProductsWithDiscount(products);
        System.out.println("Esercizio 3: " + boysDiscounted);
    }

    public List<Product> getBooksWithPriceGreaterThan100(List<Product> products) {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()) && p.getPrice() > 100)
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersWithBabyProducts(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory())))
                .collect(Collectors.toList());
    }

    public List<Product> getBoysProductsWithDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> "Boys".equals(p.getCategory()))
                .map(p -> new Product(p.id, p.name, p.category, p.price * 0.9))
                .collect(Collectors.toList());
    }
}
