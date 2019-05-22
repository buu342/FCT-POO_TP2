package Exceptions;

import java.io.Serializable;

public class InexistentItemException extends Exception implements Serializable{
    private static final long serialVersionUID = 1L;

    public InexistentItemException() {
        super();
    }
}
