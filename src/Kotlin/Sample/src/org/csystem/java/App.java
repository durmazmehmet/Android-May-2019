package org.csystem.java;

public class App {
    public static void main(String[] args)
    {
        Sample<Integer> s = new Sample<>(10);

    }
}

class Sample<T> {
    public T x;
    public Sample(T x)
    {
        this.x = x;
    }
}

