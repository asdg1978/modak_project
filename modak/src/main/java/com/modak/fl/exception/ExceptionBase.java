package com.modak.fl.exception;

public class ExceptionBase extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2800989343607892554L;

    private int errorCode;
    private String errorMessage;



    public ExceptionBase() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ExceptionBase(String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
    public ExceptionBase(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    public ExceptionBase(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    public ExceptionBase(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    public ExceptionBase(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }




}