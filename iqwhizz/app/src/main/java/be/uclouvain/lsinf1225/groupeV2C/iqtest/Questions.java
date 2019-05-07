package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends AppCompatActivity {
    public TextView countDowntxt;
    public CountDownTimer countDownTimer;
    private long timeleftms=2400000;
    Button result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Rules));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        countDowntxt=(TextView)findViewById(R.id.time);
        startTimer();
        result=(Button) findViewById(R.id.button);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultat = new Intent(getApplicationContext(), Result_quizz.class);
                startActivity(resultat);
                finish();
            }
        });
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
