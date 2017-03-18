package com.example.joe.coinproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LoadList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_list);
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
    }

    public void loadList(View view) throws IOException
    {
        CoinList cList = CoinList.getInstance();
        EditText et1 = (EditText) findViewById(R.id.url);
        boolean problem = false;
        Scanner fsc = null;

        try
        {
            URL file_url = new URL(et1.getText().toString());
            fsc = new Scanner(file_url.openStream());


        }
        catch(IOException e)
        {
            Toast.makeText(LoadList.this, "File Does Not Exist", Toast.LENGTH_SHORT).show();
            problem = true;
        }

        if(problem == false)
        {
            cList.removeAll(cList);

            while(fsc.hasNext())
            {
                String country = fsc.nextLine();
                String serialNum = fsc.nextLine();
                String denom = fsc.nextLine();
                int year = fsc.nextInt();
                fsc.nextLine();
                String material = fsc.nextLine();
                double price = fsc.nextDouble();
                fsc.nextLine();
                String image_url = fsc.nextLine();

                Coin temp = new Coin(country, serialNum, denom, year, material, price, image_url);
                cList.add(temp);
            }

            fsc.close();
            Toast.makeText(LoadList.this, "List Loaded From File", Toast.LENGTH_SHORT).show();
        }

    }

}
