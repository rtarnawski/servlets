package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    static List<User> userList;

    static {
        userList = new ArrayList<User>();
        userList.add(new User("rafi", "Rafał", "rtarnawski@gmail.com", "rafi1"));
        userList.add(new User("user1", "UserOne", "uone@gmail.com", "user1"));
        userList.add(new User("godam", "Godam", "godam@gmail.com", "godam1"));
        userList.add(new User("juri", "juri", "juri@gmail.com", "juri1"));
    }

    public static Product findProductById(List<Product> products, Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
