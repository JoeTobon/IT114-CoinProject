package com.example.joe.coinproject;

/**
 * Created by Joe on 3/13/2017.
 */

import java.util.LinkedList;

public final class CoinList extends LinkedList<Coin>
{

    private static CoinList instance = null;

    private CoinList()
    {
        // Exists only to defeat additional instantiations.
    }

    public static CoinList getInstance()
    {
        if(instance == null)
            instance = new CoinList();

        return instance;
    }

} // end CoinList