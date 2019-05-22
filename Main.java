import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.*;
import Supermarket.*;

public class Main 
{
    // Command Constants 
    public static final String COMMAND_CART_ADD         = "CRIA CARRINHO";
    public static final String COMMAND_CART_PUTITEM     = "DEPOSITA";
    public static final String COMMAND_CART_TAKEITEM    = "REMOVE";
    public static final String COMMAND_CART_LISTITEMS   = "LISTA";
    public static final String COMMAND_CART_PAY         = "PAGA";
    public static final String COMMAND_ITEM_ADD         = "CRIA ARTIGO";
    public static final String COMMAND_QUIT             = "SAIR";
     
     // Message Constants
    public static final String MESSAGE_UNKNOWN_CMD      = "Comando desconhecido.";
    public static final String MESSAGE_WRONGFORMAT      = "Formato de comando errado.";
    public static final String MESSAGE_CART_ADDED        = "Carrinho criado com sucesso.";
    public static final String MESSAGE_CART_EXISTS      = "Carrinho existente!";
    public static final String MESSAGE_CART_FULL        = "Capacidade excedida!";
    public static final String MESSAGE_CART_EMPTY       = "Carrinho vazio!";
    public static final String MESSAGE_CART_INEXISTENT  = "Carrinho inexistente!";
    public static final String MESSAGE_ITEM_ADDED       = "Artigo criado com sucesso.";
    public static final String MESSAGE_ITEM_EXISTS      = "Artigo existente!";
    public static final String MESSAGE_ITEM_INEXISTENT  = "Artigo inexistente!";
    public static final String MESSAGE_CART_PUTITEM     = "Artigo adicionado com sucesso.";
    public static final String MESSAGE_CART_TAKEITEM    = "Artigo removido com sucesso.";
    public static final String MESSAGE_CART_UNKNOWNITEM = "Artigo inexistente no carrinho!";
    public static final String MESSAGE_EXIT             = "Volte sempre.";

    
     public static void main(String[] args) 
     {   
         Scanner in = new Scanner(System.in);
         Supermarket sMarket = new SupermarketClass();
         String comm = getCommand(in);
      
         while (!comm.equals(COMMAND_QUIT))
         {
             switch (comm) {
                 case COMMAND_CART_ADD:
                     cartAdd(in, sMarket);
                     break;
                 case COMMAND_CART_PUTITEM:
                     cartPutItem(in, sMarket);
                     break;
                 case COMMAND_CART_TAKEITEM:
                     cartTakeItem(in, sMarket);
                     break;
                 case COMMAND_CART_LISTITEMS:
                     cartListItems(in, sMarket);
                     break;
                 case COMMAND_CART_PAY:
                     cartPay(in, sMarket);
                     break;
                 case COMMAND_ITEM_ADD:
                     itemAdd(in, sMarket);
                     break;
                 default:
                     System.out.println(MESSAGE_UNKNOWN_CMD);
                     break;
             }
             System.out.println();
             comm = getCommand(in);
         }
         System.out.println(MESSAGE_EXIT);
         System.out.println();
         in.close();
     }
    
    private static String getCommand(Scanner in) {
        String input;
        input = in.next().toUpperCase();
        if (input.equals("CRIA"))
            input = input+" "+in.next().toUpperCase();
        return input;
    }
    
    private static void cartAdd(Scanner in, Supermarket sMarket) {
 
        try {
            String name = in.next();
            int size = in.nextInt();
            in.nextLine();
            sMarket.addCart(name, size);
            System.out.println(MESSAGE_CART_ADDED);
        } catch (InputMismatchException e) {
            in.nextLine();
            System.out.println(MESSAGE_WRONGFORMAT);
        } catch (ExistentCartException e) {
            System.out.println(MESSAGE_CART_EXISTS);
        }
        
    }
    
    private static void itemAdd(Scanner in, Supermarket sMarket) {
        
        try {
            String name = in.next();
            int price = in.nextInt();
            int size = in.nextInt();
            in.nextLine();
            sMarket.addItem(name, size, price);
            System.out.println(MESSAGE_ITEM_ADDED);
        } catch (InputMismatchException e) {
            in.nextLine();
            System.out.println(MESSAGE_WRONGFORMAT);
        } catch (ExistentItemException e) {
            System.out.println(MESSAGE_ITEM_EXISTS);
        }
        
    }
    
    private static void cartPutItem(Scanner in, Supermarket sMarket) {
        
        try {
            String item = in.next();
            String cart = in.next();
            in.nextLine();
            sMarket.putItemInCart(item, cart);
            System.out.println(MESSAGE_CART_PUTITEM);
        } catch (InexistentCartException e) {
            System.out.println(MESSAGE_CART_INEXISTENT);
        } catch (InexistentItemException e) {
            System.out.println(MESSAGE_ITEM_INEXISTENT);
        } catch (FullCartException e) {
            System.out.println(MESSAGE_CART_FULL);
        }
        
    }
    
    private static void cartTakeItem(Scanner in, Supermarket sMarket) {
        
        try {
            String item = in.next();
            String cart = in.next();
            in.nextLine();
            sMarket.takeItemFromCart(item, cart);
            System.out.println(MESSAGE_CART_TAKEITEM);
        } catch (InexistentCartException e) {
            System.out.println(MESSAGE_CART_INEXISTENT);
        } catch (ItemNotInCartException e) {
            System.out.println(MESSAGE_CART_UNKNOWNITEM);
        }
        
    }
    
    private static void cartListItems(Scanner in, Supermarket sMarket) {
        
        try {
            String cart = in.next();
            in.nextLine();
            sMarket.cartListItems(cart);
        } catch (InexistentCartException e) {
            System.out.println(MESSAGE_CART_INEXISTENT);
        } catch (EmptyCartException e) {
            System.out.println(MESSAGE_CART_EMPTY);
        }
        
    }
    
    private static void cartPay(Scanner in, Supermarket sMarket) {
        
        try {
            String cart = in.next();
            in.nextLine();
            System.out.println(sMarket.cartPay(cart));
        } catch (InexistentCartException e) {
            System.out.println(MESSAGE_CART_INEXISTENT);
        } catch (EmptyCartException e) {
            System.out.println(MESSAGE_CART_EMPTY);
        }
        
    }
    
}
