package exceptions;

import java.io.Serializable;

public class EmptyBookException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 1L;

    public EmptyBookException() {
        super();
    }
}
