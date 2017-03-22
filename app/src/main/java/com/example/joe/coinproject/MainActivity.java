//////////////////////////////////////////////////////////////////////
//                                                                  //
//          Joseph Tobon                                            //
//          IT114, Section 004                                      //
//          Dr. Halper                                              //
//          App Project #1                                          //
//          Mar. 28, 2017                                           //
//          This app is designed to help manage a                   //
//          list of coins for sale by a coin dealer                 //
//                                                                  //
//          Option 7: Gets total price of all coins. This is        //
//          meaningful to a coin dealer as they can see the total   //
//          value of collection instantly.                          //
//                                                                  //
//          Option 8: Gets average age of every coin. This is       //
//          meaningful as coin dealer can gage the value            //
//          of individual coins even further.                       //
//                                                                  //
//////////////////////////////////////////////////////////////////////

package com.example.joe.coinproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CoinList cList;

        // set the reference to the "main" textview object so
        // we do not have to retrieve it in every method below

        tv = (TextView) findViewById(R.id.text_main);

        // create/access the list of strings

        cList = CoinList.getInstance();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Displays the list of coins forward
    public void onOption1(MenuItem i)
    {
        int j;
        String temp = "";
        CoinList cList;

        tv.setText("");

        //get the list
        cList = CoinList.getInstance();

        //display the list items
        for(j = 0; j < cList.size(); j++)
        {
            temp = cList.get(j).getCountry() + ", " + cList.get(j).getSerialNum() + ", " + cList.get(j).getDenom() + ", " + cList.get(j).getYear();
            tv.append(temp + '\n');
        }
    }

    //Displays the list of coins backward
    public void onOption2(MenuItem i)
    {
        String temp = "";
        CoinList cList = CoinList.getInstance();
        tv.setText("");

        //display list items in reverse order
        for(int k = (cList.size()-1); k >= 0; k--)
        {
            temp = cList.get(k).getCountry() + ", " + cList.get(k).getSerialNum() + ", " + cList.get(k).getDenom() + ", " + cList.get(k).getYear();
            tv.append(temp + '\n');
        }
    }

    //Adds a new coin to the list
    public void onOption3(MenuItem i)
    {
        startActivity(new Intent(this, addCoin.class));
    }

    //Shows details of a coin
    public void onOption4(MenuItem i)
    {
        startActivity(new Intent(this, DisplayCoin.class));
    }

    //Deletes (sells) a coin
    public void onOption5(MenuItem i)
    {
        startActivity(new Intent(this, removeCoin.class));
    }

    //Shows number of gold coins
    public void onOption6(MenuItem i)
    {
        CoinList cList = CoinList.getInstance();
        int goldCount = 0;
        tv.setText("");

        //Finds number of gold coins in list
        for(int ind = 0; ind < cList.size(); ind++)
        {
            if(cList.get(ind).getMaterial().equals("gold"))
            {
                goldCount++;
            }
        }

        tv.append(String.valueOf(goldCount) + " gold coin(s)");
    }

    //Gets total price of all coins
    public void onOption7(MenuItem i)
    {
        CoinList cList = CoinList.getInstance();
        int coinNum = cList.size();
        double total = 0;
        tv.setText("");

        for(int in = 0; in < coinNum; in++)
        {
            total += cList.get(in).getPrice();
        }

        tv.append("Number of Coins: " + String.valueOf(coinNum) + "\n");
        tv.append("Total Price of Coins: " + String.valueOf(total));
    }

    //Gets average age of every coin
    public void onOption8(MenuItem i)
    {
        CoinList cList = CoinList.getInstance();
        DecimalFormat form = new DecimalFormat("0.00");
        int coinNum = cList.size();
        double totalAge = 0;
        double avgAge;
        tv.setText("");

        //Gets total age of all coins for averaging purposes
        for(int in = 0; in < coinNum; in++)
        {
            totalAge += cList.get(in).getAge();
        }

        avgAge = totalAge/coinNum;
        tv.append("Number of Coins: " + String.valueOf(coinNum) + "\n");

        //Custom text view depending on number of coins
        if(coinNum == 0)
        {
            tv.append("Average Age of All Coins: " + String.valueOf(0) + " years");
        }
        else
        {
            tv.append("Average Age of All Coins: " + String.valueOf(form.format(avgAge)) + " years");
        }
    }

    //Loads list from file
    public void onOption9(MenuItem i)
    {
        startActivity(new Intent(this, LoadList.class));
    }

    //Saves list to file
    public void onOption10(MenuItem i)
    {
        startActivity(new Intent(this, SaveList.class));
    }
}
