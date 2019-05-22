package Supermarket;

import Array.*;
import Exceptions.*;

public class CartClass implements Cart {
    
    private String name;
    private int size;
    private Array<Item> items;
    
    public CartClass(String name, int size) {
        this.name = name;
        this.size = size;
        this.items = new ArrayClass<Item>();
    }
    
    public void addItem(Item item) throws FullCartException {
        if (this.size - item.getSize() < 0)
            throw new FullCartException();
        
        items.insertLast(item);
        this.size -= item.getSize();
    }
    
    public void takeItem(String itemname) throws ItemNotInCartException {
        try {
            Item item = getItem(itemname);
            this.size += item.getSize();
            this.items.remove(item);
        } catch(ItemNotInCartException E) {
            throw new ItemNotInCartException();
        }
    }
    
    public void PrintItems() throws EmptyCartException {
        Iterator<Item> it = items();

        if (!it.hasNext())
            throw new EmptyCartException();
        
        while(it.hasNext()) {
            Item item = it.next();
            System.out.println(item.getName()+" "+item.getPrice());
        } 
    }
    
    public int Pay() throws EmptyCartException {
        Iterator<Item> it = items();
        int price = 0;

        if (!it.hasNext())
            throw new EmptyCartException();
        
        while(it.hasNext()) {
            Item item = it.next();
            price += item.getPrice();
            items.remove(item); // Since the iterator keeps a copy of the array, this is safe to do
        } 
        
        return price;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getSize() {
        return this.size;
    }

    public Iterator<Item> items() {
        return this.items.iterator();
    }

    private Item getItem(String name) throws ItemNotInCartException {
        Iterator<Item> it = items();

        while(it.hasNext()) {
            Item item = it.next();
            
            if (item.getName().equals(name))
                return item;
        } 
        
        throw new ItemNotInCartException();
    }
    
}
