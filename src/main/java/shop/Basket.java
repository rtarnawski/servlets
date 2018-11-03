package shop;

import java.util.Map;

public class Basket {
    public Basket(Map<Product, Integer> basketMap) {
        this.basketMap = basketMap;
    }

    private Map<Product, Integer> basketMap;

    public Map<Product, Integer> getBasketMap() {
        return basketMap;
    }
}
