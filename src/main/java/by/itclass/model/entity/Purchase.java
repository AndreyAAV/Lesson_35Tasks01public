package by.itclass.model.entity;

public class Purchase {
    private int id;
    private String name_purchase;
    private double price_purchase;
    private int sum_purchase;


    public Purchase() {
    }

    public Purchase(int id, String name_purchase, double price_purchase, int sum_purchase) {
        this.id = id;
        this.name_purchase = name_purchase;
        this.price_purchase = price_purchase;
        this.sum_purchase = sum_purchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_purchase() {
        return name_purchase;
    }

    public void setName_purchase(String name_purchase) {
        this.name_purchase = name_purchase;
    }

    public double getPrice_purchase() {
        return price_purchase;
    }

    public void setPrice_purchase(double price_purchase) {
        this.price_purchase = price_purchase;
    }

    public int getSum_purchase() {
        return sum_purchase;
    }

    public void setSum_purchase(int sum_purchase) {
        this.sum_purchase = sum_purchase;
    }

    public double getCost() {
        return sum_purchase * price_purchase;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name_purchase='" + name_purchase + '\'' +
                ", price_purchase=" + price_purchase +
                ", sum_purchase=" + sum_purchase +
                '}';
    }
}
