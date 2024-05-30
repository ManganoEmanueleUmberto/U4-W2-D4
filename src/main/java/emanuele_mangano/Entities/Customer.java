package emanuele_mangano.Entities;

import java.util.Random;

public class Customer {
    int tier;
    private long id;
    private String name;

    public Customer(String name, int tier) {
        Random rnd = new Random();

        this.id = rnd.nextInt(10000000, 90000000);
        this.name = name;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "tier=" + tier +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getTier() {
        return tier;
    }
}
