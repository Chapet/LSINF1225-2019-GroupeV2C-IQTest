package be.uclouvain.lsinf1225.groupeV2C.iqtest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Result_quizz extends AppCompatActivity {
    TextView score;
    TextView QI;
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
        score.setText("35/40");
        QI.setText("120 DE QI");
    }
}
