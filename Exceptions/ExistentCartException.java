package Exceptions;

import java.io.Serializable;

public class ExistentCartException extends Exception implements Serializable{
    private static final long serialVersionUID = 1L;

    public ExistentCartException() {
        super();
    }
}
