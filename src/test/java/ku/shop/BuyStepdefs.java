package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("สินค้า {string} with price {float} have {int} exists")
    public void a_product_with_price_exists(String name, double price , int quantity) {
        catalog.addProduct(name, price ,quantity );

    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        if (catalog.checkStock(name)){
            order.addItem(prod, quantity);
            prod.setQuantity(prod.getQuantity() - quantity);
        }
    }



    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
}