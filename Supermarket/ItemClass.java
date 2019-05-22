package Supermarket;

public class ItemClass implements Item {
    
    private String name;
    private int size;
    private int price;
    
    public ItemClass(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getPrice() {
        return this.price;
    }

}
