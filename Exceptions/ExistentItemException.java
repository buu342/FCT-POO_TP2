package Exceptions;

import java.io.Serializable;

public class ExistentItemException extends Exception implements Serializable{
    private static final long serialVersionUID = 1L;

    public ExistentItemException() {
        super();
    }
}
