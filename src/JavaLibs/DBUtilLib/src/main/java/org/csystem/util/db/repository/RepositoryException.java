package org.csystem.util.db.repository;

public class RepositoryException extends RuntimeException {
    public RepositoryException()
    {}

    public RepositoryException(String message)
    {
        this(message, null);
    }

    public RepositoryException(String message, Throwable cause)
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
