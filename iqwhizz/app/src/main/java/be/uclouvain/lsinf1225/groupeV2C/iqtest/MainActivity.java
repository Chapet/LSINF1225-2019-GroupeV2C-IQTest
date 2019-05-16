package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tapbut;
    public static MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ring= MediaPlayer.create(MainActivity.this,R.raw.album);
        ring.start();

        this.tapbut = (TextView) findViewById(R.id.tap);

        tapbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent co = new Intent(getApplicationContext(), connexion.class);
                startActivity(co);
            }
        });

    }
}