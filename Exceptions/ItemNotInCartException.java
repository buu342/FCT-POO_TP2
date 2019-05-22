package Exceptions;

import java.io.Serializable;

public class ItemNotInCartException extends Exception implements Serializable{
    private static final long serialVersionUID = 1L;

    public ItemNotInCartException() {
        super();
    }
}
