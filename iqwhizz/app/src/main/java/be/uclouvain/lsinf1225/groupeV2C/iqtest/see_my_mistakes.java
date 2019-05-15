package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class see_my_mistakes extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button[] list = new Button[40];
    private boolean bool = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_mistakes);
        button1 = findViewById(R.id.rep1);
        button2 = findViewById(R.id.rep2);
        list[0] = button1;
        list[1] = button2;
        for(int i = 0; i < 2; i++){
            if(bool){
                list[i].setBackgroundColor(Color.GREEN);
            }
            else{
                list[i].setBackgroundColor(Color.GREEN);
            }
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Add_a_friend));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}