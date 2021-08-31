package org.csystem.util;


import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T m_value;

    private Optional()
    {
        this.m_value = null;
    }

    public static<T> Optional<T> empty()
    {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;

        return t;
    }

    private Optional(T value)
    {
        this.m_value = Objects.requireNonNull(value);
    }

    public static <T> Optional<T> of(T value)
    {
        return new Optional<>(value);
    }

    public static <T> Optional<T> ofNullable(T value)
    {
        return value == null ? Optional.<T>empty() : of(value);
    }

    public T get()
    {
        if (m_value == null)
            throw new NoSuchElementException("No value present");

        return m_value;
    }

    public boolean isPresent()
    {
        return m_value != null;
    }

    public boolean isEmpty()
    {
        return m_value == null;
    }

    public T orElse(T other)
    {
        return m_value != null ? m_value : other;
    }

    public T orElseThrow()
    {
        if (m_value == null) {
            throw new NoSuchElementException("No value present");
        }
        return m_value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<?> other = (Optional<?>) obj;
        return Objects.equals(m_value, other.m_value);
    }


    @Override
    public int hashCode()
    {
        return Objects.hashCode(m_value);
    }


    @Override
    public String toString()
    {
        return m_value != null
                ? String.format("Optional[%s]", m_value)
                : "Optional.empty";
    }
}
