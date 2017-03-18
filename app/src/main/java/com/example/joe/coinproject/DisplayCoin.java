package com.example.joe.coinproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayCoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_coin);
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

    public void displayCoin(View view)
    {
        EditText et1 = (EditText) findViewById(R.id.serialNum);
        TextView tv = (TextView) findViewById(R.id.text_main);
        CoinList cList = CoinList.getInstance();
        String serialNum = et1.getText().toString();
        boolean found = false;
        Coin temp = new Coin();
        String image_url;

        tv.setText("");

        for(int i = 0; i < cList.size(); i++)
        {
            if(cList.get(i).getSerialNum().equals(serialNum))
            {
                temp = cList.get(i);
                found = true;
                break;
            }
        }

        if(found == false)
        {
            Toast.makeText(DisplayCoin.this, "Coin not found", Toast.LENGTH_SHORT).show();
        }
        else if(found == true)
        {
            tv.append("Country: " + temp.getCountry()+ "\n");
            tv.append("Denomination: " + temp.getDenom() + "\n");
            tv.append("Year: " + String.valueOf(temp.getYear()) + "\n");
            tv.append("Material: " + temp.getMaterial() + "\n");
            tv.append("Price: " + String.valueOf(temp.getPrice()) + "\n");

            if(temp.getAge() == 0)
            {
                tv.append("Age: newly minted" + "\n");
            }
            else
            {
                tv.append("Age: " + String.valueOf(temp.getAge()) + "\n");
            }

            image_url = temp.getImageUrl();

            //use Fresco to download and display the image in the Drawee
            Uri uri = Uri.parse(image_url);  // image_url is a string
            SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image_area);
            draweeView.setImageURI(uri);
        }


    }
}
