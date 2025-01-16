package EsSTREAMS;


public class Customer {
    long id;
    String name;
    int tier;

    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', tier=" + tier + "}";
    }
}

