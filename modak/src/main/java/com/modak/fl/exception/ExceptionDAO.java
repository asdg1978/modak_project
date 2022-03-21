package com.modak.fl.exception;

/**
 * Representa una excepcion de un DAO.
 */
public class ExceptionDAO extends ExceptionBase {

    /**
     *
     */
    private static final long serialVersionUID = 148045571760837081L;

    public ExceptionDAO(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ExceptionDAO(Exception exception) {
        super(exception);
    }








}
