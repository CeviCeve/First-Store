package com.app.firststore.Adapters;

public class CacheMashine {
    static int Balance;
    static String a = Integer.toString(Balance);

    public static void getCache(int cache)
    {
        Balance += cache;
    }

    public static String setCache()
    {
        return a;
    }
}
