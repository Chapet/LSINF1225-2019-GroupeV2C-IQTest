package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Questions extends AppCompatActivity implements View.OnClickListener {
    public TextView countDowntxt;
    public CountDownTimer countDownTimer;
    private long timeleftms=2400000;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView statement;
    private int userAns;



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
        answer1 = findViewById(R.id.repa);
        answer2 = findViewById(R.id.repb);
        answer3 = findViewById(R.id.repc);
        answer4 = findViewById(R.id.repd);

        statement = findViewById(R.id.completetest);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);

        // Use the tag property to 'name' the buttons
        answer1.setTag(0);
        answer2.setTag(1);
        answer3.setTag(2);
        answer4.setTag(3);

        int index = 1;
        Object tab[];
        tab = DatabaseHelper.getQuestion(index);
        index++;
        Question_java question = new Question_java(tab[0].toString(),Integer.parseInt(tab[1].toString()),tab[2].toString(),tab[3].toString(),tab[4].toString(),tab[5].toString());
        displayQuestion(question);
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

    public void displayQuestion(Question_java question){
        answer1.setText(question.getAns1());
        answer2.setText(question.getAns2());
        answer3.setText(question.getAns3());
        answer4.setText(question.getAns4());
        statement.setText(question.getStatement());
    }

    @Override
    public void onClick(View v) {
        userAns = (int) v.getTag(); // retourne l'index du bouton surlequel le user a appuyé
        if (userAns == Question_java.getCorrectAns()) {
            DatabaseHelper.updateScore();
        }
    }
}
