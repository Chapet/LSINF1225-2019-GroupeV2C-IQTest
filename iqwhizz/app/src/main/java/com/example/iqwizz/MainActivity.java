package com.example.iqwizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView TapContinue;
    private TextView Welcome;
    private Button TapBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TapBut=(Button) findViewById(R.id.TapContButton);
        TapBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConnexionInsc = new Intent(MainActivity.this, connexion.class); //welcome=inscription
                startActivity(ConnexionInsc);
            }
        });
    }
}
