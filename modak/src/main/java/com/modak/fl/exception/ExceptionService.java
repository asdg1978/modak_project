package com.modak.fl.exception;

/**
 * Representa una excepcion de un Service.
 */
public class ExceptionService extends ExceptionBase {

    /**
     *
     */
    private static final long serialVersionUID = -3603486960587739122L;

    public ExceptionService(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);

    }

    public ExceptionService(ExceptionDAO exception) {
        super(exception);

    }

}