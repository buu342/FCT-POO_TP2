package Supermarket;

import Array.*;
import Exceptions.*;

public interface Cart {
    
    void addItem(Item item) throws FullCartException;

    void takeItem(String itemname) throws ItemNotInCartException;
    
    void PrintItems() throws EmptyCartException;
    
    int Pay() throws EmptyCartException;
    
    String getName();
    
    int getSize();
    
    Iterator<Item> items();
    
}
