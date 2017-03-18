package com.example.joe.coinproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addCoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coin);
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

    public void addCoin(View view)
    {
        EditText etC = (EditText) findViewById(R.id.country);
        EditText etS = (EditText) findViewById(R.id.serialNum);
        EditText etD = (EditText) findViewById(R.id.denom);
        EditText etY = (EditText) findViewById(R.id.year);
        EditText etM = (EditText) findViewById(R.id.material);
        EditText etP = (EditText) findViewById(R.id.price);
        EditText etI = (EditText) findViewById(R.id.image);

        String country = etC.getText().toString();
        String serialN = etS.getText().toString();
        String denom = etD.getText().toString();
        int year = Integer.parseInt(etY.getText().toString());
        String material = etM.getText().toString();
        double price = Double.parseDouble(etP.getText().toString());
        String imageUrl = etI.getText().toString();

        Coin tempC = new Coin(country, serialN, denom, year, material, price, imageUrl);
        CoinList cList = CoinList.getInstance();

        cList.add(tempC);

        Toast.makeText(addCoin.this, "Coin added to the list", Toast.LENGTH_SHORT).show();
    }

}
