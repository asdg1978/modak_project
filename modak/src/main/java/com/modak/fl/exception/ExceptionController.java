package com.modak.fl.exception;

/**
 * Representa una excepcion de un Controller.
 */
public class ExceptionController extends ExceptionBase {



    /**
     *
     */
    private static final long serialVersionUID = 4103907726416293911L;

    public ExceptionController(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);

    }

    public ExceptionController(ExceptionService exception) {
        super(exception);

    }

}
