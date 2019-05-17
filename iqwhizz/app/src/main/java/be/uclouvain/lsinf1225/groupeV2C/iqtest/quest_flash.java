package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Thread.sleep;


public class quest_flash extends AppCompatActivity implements View.OnClickListener {
    public TextView countDowntxt;
    public CountDownTimer countDownTimer;
    private long timeleftms = 300000;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView statement;
    private int userAns;
    private int [] Nques=new int[48];
    private int count = 0;
    private TextView nbQuest;
    private String affiche;
    private String compte;
    private Object [] obj=new Object[7];
    private Question_java quesab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        nbQuest=findViewById(R.id.count);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.Rules));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        countDowntxt = (TextView) findViewById(R.id.time);
        startTimer();
        answer1 = findViewById(R.id.repa);
        answer2 = findViewById(R.id.repb);
        answer3 = findViewById(R.id.repc);
        answer4 = findViewById(R.id.repd);
        statement = findViewById(R.id.completetest);
        answer1.setTag(1);
        answer2.setTag(2);
        answer3.setTag(3);
        answer4.setTag(4);
        Nques=getQuizz();
        obj=DatabaseHelper.getQuestion(Nques[0]);
        quesab=new Question_java(String.valueOf(obj[0]),(int)obj[1],String.valueOf(obj[2]),String.valueOf(obj[3]),String.valueOf(obj[4]),String.valueOf(obj[5]));
        displayQuestion(quesab);
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
        System.out.println("waaaa");
        answer1.setText(question.getAns1());
        answer2.setText(question.getAns2());
        answer3.setText(question.getAns3());
        answer4.setText(question.getAns4());
        statement.setText(question.getStatement());
    }

    public static int[] getQuizz() {
        int[] retQuizz = new int[47];
        for(int i = 1; i < 46; ++i) {
            retQuizz[i-1] = i;
        }
        System.out.println(retQuizz[0]);
        return retQuizz;
    }


    @Override
    public void onClick(View v) {

    }
    public void nextQ(View view) {
        userAns = (int) view.getTag(); // retourne l'index du bouton surlequel le user a appuyé
        obj=DatabaseHelper.getQuestion(Nques[count]);
        count++;
        DatabaseHelper.newAnswer(userAns, ((int)obj[1] == userAns), (int) obj[6], DatabaseHelper.getCurGameID());
        if(userAns == (int)obj[1]) {DatabaseHelper.updateScore();}
        if(count<47){
            System.out.println(Nques[count]);
            compte=Integer.toString(count+1);
            affiche="Question N° "+compte;
            nbQuest.setText(affiche);
            obj=DatabaseHelper.getQuestion(Nques[count-1]);
            quesab=new Question_java(String.valueOf(obj[0]),(int)obj[1],String.valueOf(obj[2]),String.valueOf(obj[3]),String.valueOf(obj[4]),String.valueOf(obj[5]));
            displayQuestion(quesab);
        }
        else {
            Intent mist = new Intent(getApplicationContext(), Result_quizz_flash.class);
            startActivity(mist);
            finish();
        }

    }
}