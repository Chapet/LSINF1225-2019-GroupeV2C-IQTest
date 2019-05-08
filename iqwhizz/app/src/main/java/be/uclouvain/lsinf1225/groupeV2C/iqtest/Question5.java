package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {
    public TextView countDowntxt;
    public CountDownTimer countDownTimer;
    private long timeleftms=300000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Rules));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        countDowntxt=(TextView)findViewById(R.id.time);
        startTimer();
    }
    public void startTimer(){
        countDownTimer=new CountDownTimer(timeleftms,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftms=millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Intent result = new Intent(getApplicationContext(), menu.class);
                startActivity(result);
                finish();
            }
        }.start();
    }
    public void updateTimer(){
        int minutes = (int) timeleftms/60000;
        int sec=(int)timeleftms%60000/1000;
        String timeLeftTxt;
        timeLeftTxt="Time : "+minutes;
        timeLeftTxt+=":";
        if(sec<10)timeLeftTxt+="0";
        timeLeftTxt+=sec;
        countDowntxt.setText(timeLeftTxt);
    }
}
