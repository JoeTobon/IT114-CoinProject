package com.example.joe.coinproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class removeCoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_coin);
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

    public void removeCoin(View view)
    {
        EditText et1 = (EditText) findViewById(R.id.serialNum);
        CoinList cList = CoinList.getInstance();
        String serialNum = et1.getText().toString();
        boolean found = false;

        //Removes coin from list if serial number found
        for(int i = 0; i < cList.size(); i++)
        {
            if(cList.get(i).getSerialNum().equals(serialNum))
            {
                cList.remove(cList.get(i));
                found = true;
                break;
            }
        }

        //Displays a message depending on whether coin is removed of not
        if(found == true)
        {
            Toast.makeText(removeCoin.this, "Removed item from list", Toast.LENGTH_SHORT).show();
        }
        else if(found == false)
        {
            Toast.makeText(removeCoin.this, "Item not removed from list", Toast.LENGTH_SHORT).show();
        }
    }
}
