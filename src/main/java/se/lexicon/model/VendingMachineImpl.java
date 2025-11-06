package se.lexicon.model;

public class VendingMachineImpl implements VendingMachine {
    private Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    @Override
    public void addCurrency(Currency amount) {
        if (amount == null) throw new IllegalArgumentException("amount is null");
        depositPool += amount.getValue();
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        // find the array index of the product with this id
        int indexFoundAt = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                indexFoundAt = i; // <-- use array index, not id
                break;
            }
        }
        if (indexFoundAt == -1) throw new RuntimeException("That product was not found");

        Product foundProduct = products[indexFoundAt];
        int price = (int) Math.ceil(foundProduct.getPrice()); // prices are double; pool is int

        if (depositPool >= price) {                           // enough money if >=
            depositPool -= price;                             // subtract correctly

            // remove the product from the array (simulate 1 stock per item)
            Product[] newProducts = new Product[products.length - 1];
            for (int i = 0, j = 0; i < products.length; i++) {
                if (i != indexFoundAt) {
                    newProducts[j++] = products[i];
                }
            }
            products = newProducts;

            return foundProduct;
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    @Override
    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        return change;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product.examine();
        }
        throw new RuntimeException("Product was not found");
    }

    @Override
    public String[] getProducts() {
        String[] descriptions = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            descriptions[i] = products[i].examine();
        }
        return descriptions;
    }
}
