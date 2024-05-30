package emanuele_mangano.Entities;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {

    private long id;
    private String status;
    private Date orderDate;
    private Date deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(String status, List<Product> products, Date orderDate, Date deliveryDate, Customer customer) {
        Random rnd = new Random();

        this.id = rnd.nextInt(10000000, 90000000);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "\n" +
                "id: " + id +
                ", status: " + status +
                ", orderDate: " + orderDate +
                ", deliveryDate: " + deliveryDate +
                ", products:\n " + products +
                ", customer: " + customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
}
