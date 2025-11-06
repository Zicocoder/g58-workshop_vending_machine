package se.lexicon.model;

public class Chocolate implements Product {
    private final int id;
    private double price;
    private String productName;

    public Chocolate(double price, String productName) {
        this.id = Product.SEQUENCER.getAndIncrement();
        this.price = price;
        this.productName = productName;
    }

    @Override
    public String examine() {
        return "Chocolate{" +
                "id=" + id +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public String use() {
        return "You eat the chocolate.";
    }

    @Override public int getId() { return id; }
    @Override public double getPrice() { return price; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public String getProductName() { return productName; }
    @Override public void setProductName(String productName) { this.productName = productName; }
}
