package Supermarket;

import Array.*;
import Exceptions.*;

public class SupermarketClass implements Supermarket {

    private Array<Cart> carts;
    private Array<Item> items;
    
    public SupermarketClass() {
        this.carts = new ArrayClass<Cart>();
        this.items = new ArrayClass<Item>();
    }
    
    public void addCart(String name, int size) throws ExistentCartException {
        if (cartExists(name))
            throw new ExistentCartException();
        
        this.carts.insertLast(new CartClass(name, size));
    }
    
    public void addItem(String name, int size, int price) throws ExistentItemException {
        if (itemExists(name))
            throw new ExistentItemException();
        
        this.items.insertLast(new ItemClass(name, size, price));
    }
    
    public void putItemInCart(String itemname, String cartname) throws InexistentItemException, InexistentCartException, FullCartException {
        Cart cart;
        Item item;
        
        try {
            cart = getCart(cartname);
            item = getItem(itemname);
            cart.addItem(item);
        } catch (InexistentCartException E) {
            throw new InexistentCartException();
        } catch (InexistentItemException E) {
            throw new InexistentItemException();
        } catch (FullCartException E) {
            throw new FullCartException();
        }
    }
    
    public void takeItemFromCart(String itemname, String cartname) throws InexistentCartException, ItemNotInCartException {
        Cart cart;
        
        try {
            cart = getCart(cartname);
            cart.takeItem(itemname);
        } catch (InexistentCartException E) {
            throw new InexistentCartException();
        } catch (ItemNotInCartException E) {
            throw new ItemNotInCartException();
        }
    }
    
    public void cartListItems(String cartname) throws InexistentCartException, EmptyCartException {
        Cart cart;
        
        try {
            cart = getCart(cartname);
            cart.PrintItems();
        } catch (InexistentCartException E) {
            throw new InexistentCartException();
        } catch (EmptyCartException E) {
            throw new EmptyCartException();
        }
    }
    
    public int cartPay(String cartname) throws InexistentCartException, EmptyCartException {
        Cart cart;
        
        try {
            cart = getCart(cartname);
            return cart.Pay();
        } catch (InexistentCartException E) {
            throw new InexistentCartException();
        } catch (EmptyCartException E) {
            throw new EmptyCartException();
        }
    }
    
    public Iterator<Cart> carts() {
        return this.carts.iterator();
    }
    
    public Iterator<Item> items() {
        return this.items.iterator();
    }
    
    private Cart getCart(String name) throws InexistentCartException {
        Iterator<Cart> it = carts();
        
        while (it.hasNext()) {
            Cart cart = it.next();
            
            if (cart.getName().equals(name))
                return cart;
        }
        
        throw new InexistentCartException();
    }
    
    private Item getItem(String name) throws InexistentItemException {
        Iterator<Item> it = items();
        
        while (it.hasNext()) {
            Item item = it.next();
            
            if (item.getName().equals(name))
                return item;
        }
        
        throw new InexistentItemException();
    }
    
    private boolean cartExists(String name) {
        Iterator<Cart> it = carts();
        
        while (it.hasNext()) {
            Cart cart = it.next();
            
            if (cart.getName().equals(name))
                return true;
        }
        
        return false;
    }
    
    private boolean itemExists(String name) {
        Iterator<Item> it = items();
        
        while (it.hasNext()) {
            Item item = it.next();
            
            if (item.getName().equals(name))
                return true;
        }
        
        return false;
    }

}
