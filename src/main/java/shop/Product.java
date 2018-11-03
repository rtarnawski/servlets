package shop;

public class Product {
    private String name;
    private String description;
    private static int counter = 1;
    private Integer id;
    private Integer price;


    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.id = counter;
        this.price = price;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
