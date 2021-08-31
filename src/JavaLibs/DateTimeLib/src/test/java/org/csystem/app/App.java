package org.csystem.app;

import org.csystem.util.datetime.DateTime;
import org.csystem.util.datetime.Month;

public class App {
    public static void main(String[] args)
    {
        DateTime now = DateTime.now();
        DateTime today = DateTime.today();


        System.out.println(now);
        System.out.println(today);
    }
}
