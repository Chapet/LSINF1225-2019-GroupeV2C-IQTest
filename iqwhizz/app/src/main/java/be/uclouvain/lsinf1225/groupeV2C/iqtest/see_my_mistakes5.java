package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class see_my_mistakes5 extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button[] list = new Button[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_mistakes5);
        button1 = findViewById(R.id.rep1);
        button2 = findViewById(R.id.rep2);
        button3 = findViewById(R.id.rep3);
        button4 = findViewById(R.id.rep4);
        button5 = findViewById(R.id.rep5);
        list[0] = button1;
        list[1] = button2;
        list[2] = button3;
        list[3] = button4;
        list[4] = button5;
        for(int i = 0; i < list.length; i++){
            if(DatabaseHelper.getCorrect(i, 5)){
                list[i].setBackgroundColor(Color.GREEN);
            }
            else{
                list[i].setBackgroundColor(Color.RED);
            }
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Add_a_friend));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}