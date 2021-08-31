package org.csystem.util.db.service;

public class ServiceException extends RuntimeException {
    public ServiceException()
    {}

    public ServiceException(String message)
    {
        this(message, null);
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        Throwable ex = this.getCause();

        return String.format("Message:%s%s",
                super.getMessage(), ex == null ? "" : ", Cause Message:" + ex.getMessage());
    }
}
