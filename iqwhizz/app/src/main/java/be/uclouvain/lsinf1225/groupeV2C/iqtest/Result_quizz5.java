package be.uclouvain.lsinf1225.groupeV2C.iqtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Result_quizz5 extends AppCompatActivity {
    TextView score;
    TextView QI;
    Button seem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quizz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        toolbar.setTitle(getResources().getString(R.string.friends));
        toolbar.setNavigationIcon(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        score=(TextView) findViewById(R.id.score);
        QI=(TextView) findViewById(R.id.QI);
        score.setText(DatabaseHelper.getScore()+"/5");
        int pri = DatabaseHelper.getScore()*20+30;
        QI.setText(pri +" DE QI");

        this.seem = (Button) findViewById(R.id.see_mistakes);
        seem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seem = new Intent(getApplicationContext(), see_my_mistakes5.class);
                startActivity(seem);
            }
        });
    }
}
