package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView tapbut;
    public MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ring= MediaPlayer.create(MainActivity.this,R.raw.cigale);
        ring.start();

        this.tapbut = (TextView) findViewById(R.id.tap);

        tapbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent co = new Intent(getApplicationContext(), connexion.class);
                startActivity(co);
                finish();
            }
        });

    }

    /*private String display(){
        Test mDbHelper = new Test(getBaseContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor testdata = mDbHelper.getTestData();

        mDbHelper.close();

        return testdata.getString(testdata .getPosition());
    }*/
}