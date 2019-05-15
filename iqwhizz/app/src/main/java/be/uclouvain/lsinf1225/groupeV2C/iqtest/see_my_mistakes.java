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
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button button37;
    private Button button38;
    private Button button39;
    private Button button40;
    private Button[] list = new Button[40];
    private boolean bool = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_mistakes);
        button1 = findViewById(R.id.rep1);
        button2 = findViewById(R.id.rep2);
        button3 = findViewById(R.id.rep3);
        button4 = findViewById(R.id.rep4);
        button5 = findViewById(R.id.rep5);
        button6 = findViewById(R.id.rep6);
        button7 = findViewById(R.id.rep7);
        button8 = findViewById(R.id.rep8);
        button9 = findViewById(R.id.rep9);
        button10 = findViewById(R.id.rep10);
        button11 = findViewById(R.id.rep11);
        button12 = findViewById(R.id.rep12);
        button13 = findViewById(R.id.rep13);
        button14 = findViewById(R.id.rep14);
        button15 = findViewById(R.id.rep15);
        button16 = findViewById(R.id.rep16);
        button17 = findViewById(R.id.rep17);
        button18 = findViewById(R.id.rep18);
        button19 = findViewById(R.id.rep19);
        button20 = findViewById(R.id.rep20);
        button21 = findViewById(R.id.rep21);
        button22 = findViewById(R.id.rep22);
        button23 = findViewById(R.id.rep23);
        button24 = findViewById(R.id.rep24);
        button25 = findViewById(R.id.rep25);
        button26 = findViewById(R.id.rep26);
        button27 = findViewById(R.id.rep27);
        button28 = findViewById(R.id.rep28);
        button29 = findViewById(R.id.rep29);
        button30 = findViewById(R.id.rep30);
        button31 = findViewById(R.id.rep31);
        button32 = findViewById(R.id.rep32);
        button33 = findViewById(R.id.rep33);
        button34 = findViewById(R.id.rep34);
        button35 = findViewById(R.id.rep35);
        button36 = findViewById(R.id.rep36);
        button37 = findViewById(R.id.rep37);
        button38 = findViewById(R.id.rep38);
        button39 = findViewById(R.id.rep39);
        button40 = findViewById(R.id.rep40);
        list[0] = button1;
        list[1] = button2;
        list[2] = button3;
        list[3] = button4;
        list[4] = button5;
        list[5] = button6;
        list[6] = button7;
        list[7] = button8;
        list[8] = button9;
        list[9] = button10;
        list[10] = button11;
        list[11] = button12;
        list[12] = button13;
        list[13] = button14;
        list[14] = button15;
        list[15] = button16;
        list[16] = button17;
        list[17] = button18;
        list[18] = button19;
        list[19] = button20;
        list[20] = button21;
        list[21] = button22;
        list[22] = button23;
        list[23] = button24;
        list[24] = button25;
        list[25] = button26;
        list[26] = button27;
        list[27] = button28;
        list[28] = button29;
        list[29] = button30;
        list[30] = button31;
        list[31] = button32;
        list[32] = button33;
        list[33] = button34;
        list[34] = button35;
        list[35] = button36;
        list[36] = button37;
        list[37] = button38;
        list[38] = button39;
        list[39] = button40;
        for(int i = 0; i < list.length; i++){
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