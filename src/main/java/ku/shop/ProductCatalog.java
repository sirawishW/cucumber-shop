package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private int quantity;
    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        products.put(name, new Product(name, price, quantity));
    }

    public void addProduct(String name, double price) {
        addProduct(name, price, 0);
    }

    public boolean checkStock(String name){
        if (products.get(name).getQuantity() <= 0){
            throw new IllegalArgumentException("ของมีไม่พอจ้า");
        }
        return true;
    }

    public Product getProduct(String name) {
        return products.get(name);
    }


}