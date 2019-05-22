package Supermarket;

import Array.*;
import Exceptions.*;

public interface Supermarket {

    void addCart(String name, int size) throws ExistentCartException;
    
    void addItem(String name, int size, int price) throws ExistentItemException;
    
    void putItemInCart(String itemname, String cartname) throws InexistentItemException, InexistentCartException, FullCartException;
    
    void takeItemFromCart(String itemname, String cartname) throws InexistentCartException, ItemNotInCartException;
    
    void cartListItems(String cartname) throws InexistentCartException, EmptyCartException;
    
    int cartPay(String cartname) throws InexistentCartException, EmptyCartException;
    
    Iterator<Cart> carts();
    
    Iterator<Item> items();
    
}
