package se.lexicon.model;

public interface Product {
  String examine();
  String use();
  int getid();
  String getProductName();
  void setProductName();
  double getPrice();
  void setPrice(double price);
}
