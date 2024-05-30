package emanuele_mangano;

import com.github.javafaker.Faker;
import emanuele_mangano.Entities.Customer;
import emanuele_mangano.Entities.Order;
import emanuele_mangano.Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Customer> customersList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();
        List<Order> ordersList = new ArrayList<>();

        Supplier<Customer> customerSupplier = () -> {
            Faker faker = new Faker();
            Random rnd = new Random();

            return new Customer(faker.leagueOfLegends().champion(), rnd.nextInt(1, 5));

        };

        Supplier<Product> productSupplier = () -> {
            Faker faker = new Faker();
            Random rnd = new Random();

            return new Product(faker.food().dish(), "Food", rnd.nextDouble(5, 10));
        };

        Supplier<Order> orderSupplier = () -> {
            Faker faker = new Faker();
            Random rnd = new Random();
            int statusIndex = rnd.nextInt(0, 3), productsIndex = rnd.nextInt(0, 9), customersIndex = rnd.nextInt(0, 4);
            String[] ArrayOfStatus = {"Delivered", "Pending", "Created", "Processing"};


            return new Order(ArrayOfStatus[statusIndex], productsList.stream().limit(productsIndex).toList(), faker.date().future(2, TimeUnit.DAYS), faker.date().future(20, TimeUnit.DAYS), customersList.get(customersIndex));
        };


        for (int i = 0; i < 5; i++) {
            customersList.add(customerSupplier.get());
        }

        for (int i = 0; i < 10; i++) {
            productsList.add(productSupplier.get());
        }

        for (int i = 0; i < 3; i++) {
            ordersList.add(orderSupplier.get());
        }
        System.out.println("\n***** All the Customers ********");
        System.out.println(customersList);
        System.out.println("\n***** All the Products ********");
        System.out.println(productsList);
        System.out.println("\n***** All the Orders ********");
        System.out.println(ordersList);

        //EXERCISE 1
        Map<String, List<Order>> orderByCustomer = ordersList.stream().collect(Collectors.groupingBy(order -> order.getCustomer().getName()));
        System.out.println("\n***** Orders By Customer ********");
        orderByCustomer.forEach((customer, products) -> System.out.println("\n" + customer + " has ordered: \n" + products));

        
    }
}
