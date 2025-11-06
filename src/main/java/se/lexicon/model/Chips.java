package se.lexicon.model;

public class Chips implements Product {
    private final int id;
    private double price;
    private String productName;

    public Chips(double price, String productName) {
        this.id = Product.SEQUENCER.getAndIncrement();
        this.price = price;
        this.productName = productName;
    }

    @Override
    public String examine() {
        return "Chips{" +
                "id=" + id +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public String use() {
        return "You eat the chips.";
    }

    @Override public int getId() { return id; }
    @Override public double getPrice() { return price; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public String getProductName() { return productName; }
    @Override public void setProductName(String productName) { this.productName = productName; }
}
