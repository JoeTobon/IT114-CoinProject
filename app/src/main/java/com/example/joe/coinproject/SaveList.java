package com.example.joe.coinproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_list);
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

    public void saveList(View view) throws IOException
    {
        CoinList cList = CoinList.getInstance();
        EditText et1 = (EditText) findViewById(R.id.url);

        File outfile = new File(getExternalFilesDir(null), et1.getText().toString());
        FileWriter fw = new FileWriter(outfile);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for(int i = 0; i < cList.size(); i++)
        {
            pw.write(cList.get(i).getCountry() + "\n");
            pw.write(cList.get(i).getSerialNum() + "\n");
            pw.write(cList.get(i).getDenom() + "\n");
            pw.print(cList.get(i).getYear());
            pw.write("\n");
            pw.write(cList.get(i).getMaterial() + "\n");
            pw.print(cList.get(i).getPrice());
            pw.write("\n");
            pw.write(cList.get(i).getImageUrl() + "\n");
        }

        pw.close();

        Toast.makeText(SaveList.this, "List Loaded From File", Toast.LENGTH_SHORT).show();
    }

}
