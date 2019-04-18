package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Tap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Tap = (TextView) findViewById(R.id.Tap);
        Tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conins = new Intent(getApplicationContext(), connexion.class);
                startActivity(conins);
                finish();
            }
        });
    }
}