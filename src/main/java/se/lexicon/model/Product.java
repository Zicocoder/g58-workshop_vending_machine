package se.lexicon.model;

import java.util.concurrent.atomic.AtomicInteger;

public interface Product {
    AtomicInteger SEQUENCER = new AtomicInteger(0);
    String examine();
    String use();
    int getId();
    String getProductName();
    void setProductName(String productName);
    double getPrice();
    void setPrice(double price);
}